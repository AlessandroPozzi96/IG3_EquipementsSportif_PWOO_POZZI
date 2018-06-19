package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness.Promotion;
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
    private Promotion promotion;

    @Autowired
    public PanierController(ArticleValidator articleValidator) {
        this.articleValidator = articleValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @Valid @ModelAttribute(Constants.PANIER)Panier panier) {
        model.addAttribute("title", "Panier Page");
        promotion = new Promotion();
        model.addAttribute("promotion", promotion);
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

    @RequestMapping(method = RequestMethod.POST, params = {"ajouter", "articleJson"})
    public String formDataAdd(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @ModelAttribute(Constants.PANIER) Panier panier) {
        Article article = panier.jsonToArticle(articleJson);
        Integer quantiteActuelle = panier.getPanierHashMap().get(article) + 1;
        panier.modifierQuantitePanier(article, quantiteActuelle);
        System.out.println("CONTROLLER AJOUTER " + "ARTICLE : " + article.getLibelle() + " QUANTITE : " + panier.getNbArticles());
        return "redirect:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"enlever", "articleJson"})
    public String formDataRemove(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @ModelAttribute(Constants.PANIER) Panier panier) {
        Article article = panier.jsonToArticle(articleJson);
        Integer quantiteActuelle = panier.getPanierHashMap().get(article);
        if (quantiteActuelle <= 1) {
            System.out.println("CONTROLLER ENLEVER " + "ARTICLE : " + article.getLibelle() + " QUANTITE = 1");
            return "redirect:panier";
        }
        else
        {
            quantiteActuelle--;
            panier.modifierQuantitePanier(article, quantiteActuelle);
            System.out.println("CONTROLLER ENLEVER " + "ARTICLE : " + article.getLibelle() + " QUANTITE : " + panier.getNbArticles());
            return "redirect:panier";
        }
    }
}
