package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Taille;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {
    private TypeArticleDAO typeArticleDAO;

    @Autowired
    public PanierController(TypeArticleDAO typeArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
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
}
