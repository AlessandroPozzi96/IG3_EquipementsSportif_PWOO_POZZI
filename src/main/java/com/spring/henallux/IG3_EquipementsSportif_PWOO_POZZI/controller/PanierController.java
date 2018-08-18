package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness.Promotion;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {
    private Promotion promotion;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(Constants.PANIER)Panier panier) {
        promotion = new Promotion();
        model.addAttribute("promotion", promotion);
        return "integrated:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"supprimer", "articleJson"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String formDataSuppression(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @ModelAttribute(Constants.PANIER)Panier panier)
    {
        Article article = panier.jsonToArticle(articleJson);
        panier.removeArticlesPanier(article);
        System.out.println("CONTROLLER PANIER -> SUPPRESSION " + "ARTICLE : " + article.getLibelle());
        return "redirect:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"ajouter", "articleJson"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String formDataAdd(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @ModelAttribute(Constants.PANIER) Panier panier) {
        Article article = panier.jsonToArticle(articleJson);
        Integer quantiteActuelle = panier.getPanierHashMap().get(article) + 1;
        panier.modifierQuantitePanier(article, quantiteActuelle);
        System.out.println("CONTROLLER PANIER -> AJOUT " + "ARTICLE : " + article.getLibelle() + " QUANTITE : " + panier.getNbArticlesPanier());
        return "redirect:panier";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"enlever", "articleJson"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String formDataRemove(Model model, @RequestParam(required = true, defaultValue = "1") String articleJson, @ModelAttribute(Constants.PANIER) Panier panier) {
        Article article = panier.jsonToArticle(articleJson);
        Integer quantiteActuelle = panier.getPanierHashMap().get(article);
        if (quantiteActuelle <= 1) {
            System.out.println("CONTROLLER PANIER -> ENLEVER " + "ARTICLE : " + article.getLibelle() + " QUANTITE = 1");
            return "redirect:panier";
        }
        else
        {
            quantiteActuelle--;
            panier.modifierQuantitePanier(article, quantiteActuelle);
            System.out.println("CONTROLLER PANIER -> ENLEVER " + "ARTICLE : " + article.getLibelle() + " QUANTITE : " + panier.getNbArticlesPanier());
            return "redirect:panier";
        }
    }
}
