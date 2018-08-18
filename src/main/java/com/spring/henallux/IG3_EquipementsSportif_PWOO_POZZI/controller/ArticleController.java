package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.*;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/article")
@SessionAttributes({Constants.PANIER})
public class ArticleController {
    private TypeArticleDAO typeArticleDAO;
    private ImageDAO imageDAO;
    private Integer cb;
    private DisponibleDAO disponibleDAO;
    private DisponibleEnCouleurDAO disponibleEnCouleurDAO;
    private TypeArticle typeArticle;
    private TranslationArticleDAO translationArticleDAO;
    private TranslationArticle translationArticle;
    private TranslationCouleurDAO translationCouleurDAO;
    private TranslationCouleur translationCouleur;

    @Autowired
    public ArticleController(TypeArticleDAO typeArticleDAO, ImageDAO imageDAO, DisponibleDAO disponibleDAO, DisponibleEnCouleurDAO disponibleEnCouleurDAO, TranslationArticleDAO translationArticleDAO, TranslationCouleurDAO translationCouleurDAO) {
        this.translationCouleurDAO = translationCouleurDAO;
        this.translationArticleDAO = translationArticleDAO;
        this.disponibleEnCouleurDAO = disponibleEnCouleurDAO;
        this.typeArticleDAO = typeArticleDAO;
        this.imageDAO = imageDAO;
        this.disponibleDAO = disponibleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"codeBarre"})
    public String home(@RequestParam(required = true, defaultValue = "1") Integer codeBarre, Model model, @CookieValue(value = "myLocaleCookie", required = true, defaultValue = "fr") String myLocaleCookie) {
        typeArticle = typeArticleDAO.findByCodeBarre(codeBarre);
        model.addAttribute("article", typeArticle);
        model.addAttribute("images", imageDAO.findByArticleEntityCodeBarre(codeBarre));
        cb = codeBarre;
        model.addAttribute("tailles", disponibleDAO.findAllByCodeBarre(cb));
        ArrayList<TranslationCouleur> couleurs = obtentionCouleurs(disponibleEnCouleurDAO.findAllByCodeBarre(cb), myLocaleCookie);
        model.addAttribute("couleurs", couleurs);
        translationArticle = translationArticleDAO.findByTranslationArticlePK_CodeBarre_FKAndTranslationArticlePK_LangageID_FK(cb, myLocaleCookie);
        model.addAttribute("translationArticle", translationArticle);
        return "integrated:article";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getArticle(Model model, @Valid @ModelAttribute(Constants.PANIER) Panier panier, BindingResult result) {
        if (result.hasErrors()) {
            return "integrated:article?codeBarre=" + cb;
        }

        try {
            Article article = new Article(translationArticle.getLibelle(), cb, typeArticle.getPrix(), panier.getTaille(), panier.getCouleur());
            Integer articleExiste = panier.getPanierHashMap().get(article);
            if (articleExiste != null) {
                panier.addAchatPanier(article, ++articleExiste);
            }
            else
            {
                panier.addAchatPanier(article, 1);
            }
            System.out.println("ArticleController : OK → DANS LE TRY ");
        } catch (ModelException e) {
            model.addAttribute("error", e.getMessage());
            System.out.println("ArticleController : KO → DANS LE CATCH !");
            return "integrated:error";
        }
        System.out.println("ArticleController : Nb articles panier : " + panier.getNbArticlesPanier());
        return "redirect:article?codeBarre=" + cb;
    }

    public ArrayList<TranslationCouleur> obtentionCouleurs(ArrayList<DisponibleEnCouleur> disponibleEnCouleurs, String lang) {
        ArrayList<TranslationCouleur> couleurs = new ArrayList<>();
        for (DisponibleEnCouleur disponibleEnCouleur : disponibleEnCouleurs) {
            translationCouleur = translationCouleurDAO.findByTranslationCouleurPK_IdCouleur_FKAndTranslationCouleurPK_LangageID_FK(disponibleEnCouleur.getCouleur_fk(), lang);
            couleurs.add(translationCouleur);
        }
        return couleurs;
    }
}
