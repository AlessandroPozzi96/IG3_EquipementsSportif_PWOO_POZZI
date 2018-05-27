package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.LignePanier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.NB_ARTICLES})
public class PanierController {
    private TypeArticleDAO typeArticleDAO;
    private ArrayList<LignePanier> lignesPaniers;
    private LignePanier lignePanier;
    private TypeArticle typeArticle;

    @Autowired
    public PanierController(TypeArticleDAO typeArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @Valid @ModelAttribute(Constants.NB_ARTICLES)Article article) {
        lignesPaniers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : article.getAchatsArticles().entrySet()) {
            typeArticle = typeArticleDAO.findByCodeBarre(entry.getKey());
            lignePanier = new LignePanier(typeArticle.getCodeBarre(), typeArticle.getLibelle_fr(), entry.getValue(), entry.getValue() * typeArticle.getPrix(), typeArticle.getPrix());
            lignesPaniers.add(lignePanier);
        }
        model.addAttribute("title", "Panier Page");
        model.addAttribute("lignesPaniers", lignesPaniers);
        model.addAttribute("prixTot", getPrixTot());
        model.addAttribute("aSupprimer", new Article());
        return "integrated:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"supprimer", "codeBarre"})
    public String formDataSuppression(Model model, @RequestParam(required = true, defaultValue = "1") Integer codeBarre, @Valid @ModelAttribute(Constants.NB_ARTICLES)Article article)
    {
        System.out.println("CONTROLLER SUPPRIMER" + "codeBarre = " + codeBarre);
        article.removeArticlesPanier(codeBarre);
        return "redirect:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"modifier", "codeBarre"})
    public String formDataModification(Model model, @RequestParam(required = true, defaultValue = "1") Integer codeBarre) {
        System.out.println("CONTROLLER MODIFIER" + "codeBarre = " + codeBarre);
        return "redirect:article?codeBarre=" + codeBarre;
    }

    public Double getPrixTot() {
        Double prixTot = 0.0;
        for (LignePanier lignePanier : lignesPaniers) {
            prixTot += lignePanier.getPrix();
        }
        return prixTot;
    }


}
