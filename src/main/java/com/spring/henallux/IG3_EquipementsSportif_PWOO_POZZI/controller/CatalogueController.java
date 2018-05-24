package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.CategorieArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/catalogue")
@SessionAttributes({Constants.NB_ARTICLES})
public class CatalogueController {
    private CategorieArticleDAO categorieArticleDAO;

    @ModelAttribute(Constants.NB_ARTICLES)
    public Article getNbArticles() {
        return new Article();
    }

    @Autowired
    public CatalogueController(CategorieArticleDAO categorieArticleDAO) {
        this.categorieArticleDAO = categorieArticleDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.NB_ARTICLES) Article nbArticles) {
        model.addAttribute("title", "Catalogue Page");
        model.addAttribute("categoriesArticles", categorieArticleDAO.getAllCategories());
        return "integrated:catalogue";
    }

}
