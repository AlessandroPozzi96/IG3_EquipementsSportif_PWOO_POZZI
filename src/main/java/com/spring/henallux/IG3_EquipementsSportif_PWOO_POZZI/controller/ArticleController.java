package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.*;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ArticleValidator;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/article")
@SessionAttributes({Constants.PANIER})
public class ArticleController {
    private TypeArticleDAO typeArticleDAO;
    private ImageDAO imageDAO;
    private Integer cb;
    private ArticleValidator articleValidator;
    private DisponibleDAO disponibleDAO;
    private DisponibleEnCouleurDAO disponibleEnCouleurDAO;
    private TypeArticle typeArticle;
    private TranslationArticleDAO translationArticleDAO;

    @Autowired
    public ArticleController(TypeArticleDAO typeArticleDAO, ImageDAO imageDAO, ArticleValidator articleValidator, DisponibleDAO disponibleDAO, DisponibleEnCouleurDAO disponibleEnCouleurDAO, TranslationArticleDAO translationArticleDAO) {
        this.translationArticleDAO = translationArticleDAO;
        this.disponibleEnCouleurDAO = disponibleEnCouleurDAO;
        this.typeArticleDAO = typeArticleDAO;
        this.imageDAO = imageDAO;
        this.articleValidator = articleValidator;
        this.disponibleDAO = disponibleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"codeBarre"})
    public String home(@RequestParam(required = true, defaultValue = "1") Integer codeBarre, Model model) {
        model.addAttribute("title", "Panier Page");
        typeArticle = typeArticleDAO.findByCodeBarre(codeBarre);
        model.addAttribute("article", typeArticle);
        model.addAttribute("images", imageDAO.findByArticleEntityCodeBarre(codeBarre));
        cb = codeBarre;
        model.addAttribute("tailles", disponibleDAO.findAllByCodeBarre(cb));
        model.addAttribute("couleurs", disponibleEnCouleurDAO.findAllByCodeBarre(cb));
        model.addAttribute("translationArticleDAO", translationArticleDAO);
        return "integrated:article";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getArticle(Model model, @Valid @ModelAttribute(Constants.PANIER) Panier panier, BindingResult result) {
        articleValidator.validate(panier, result);
        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "integrated:error";
        }

        try {
            Article article = new Article(typeArticle.getLibelle_fr(), cb, typeArticle.getPrix(), panier.getTaille(), panier.getCouleur());
            Integer articleExiste = panier.getPanierHashMap().get(article);
            if (articleExiste != null) {
                panier.addAchatPanier(article, articleExiste++);
            }
            else
            {
                panier.addAchatPanier(article, 1);
            }
            System.out.println("ArticleController : Ok → DANS LE TRY ");
        } catch (ModelException e) {
            model.addAttribute("error", e.getMessage());
            System.out.println("ArticleController : Erreur → DANS LE CATCH");
            return "integrated:error";
        }
        System.out.println("ArticleController : Nb panier totale commander : " + panier.getNbArticlesPanier());
        return "redirect:article?codeBarre=" + cb;
    }
}
