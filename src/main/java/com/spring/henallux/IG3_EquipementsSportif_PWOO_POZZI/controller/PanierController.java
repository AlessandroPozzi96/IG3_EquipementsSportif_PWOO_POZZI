package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ArticleValidator;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {
    private ArticleValidator articleValidator;

    @Autowired
    public PanierController(ArticleValidator articleValidator) {
        this.articleValidator = articleValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @Valid @ModelAttribute(Constants.PANIER)Panier panier) {
        model.addAttribute("title", "Panier Page");
        return "integrated:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"supprimer", "articleJson"}, produces = "application/json")
    public String formDataSuppression(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @Valid @ModelAttribute(Constants.PANIER)Panier panier)
    {
        Article article = panier.jsonToArticle(articleJson);
        panier.removeArticlesPanier(article);
        System.out.println("CONTROLLER SUPPRIMER " + "ARTICLE : " + article.getLibelle());
        return "redirect:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"modifier", "articleJson"})
    public String formDataModification(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @Valid @ModelAttribute(Constants.PANIER) Panier panier, BindingResult result) {
        articleValidator.validate(panier, result);
        if (result.hasErrors() ) {
            return "integrated:panier";
        }
        Article article = panier.jsonToArticle(articleJson);
        try {
            panier.modifierQuantitePanier(article, panier.getNbArticles());
            System.out.println("CONTROLLER MODIFIER " + "ARTICLE : " + article.getLibelle() + " QUANTITE : " + panier.getNbArticles());
        } catch (ModelException e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
        return "redirect:panier";
    }
}
