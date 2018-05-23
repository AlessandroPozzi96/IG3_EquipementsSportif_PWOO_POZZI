package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.CategorieArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController {
    private CategorieArticleDAO categorieArticleDAO;

    @Autowired
    public CatalogueController(CategorieArticleDAO categorieArticleDAO) {
        this.categorieArticleDAO = categorieArticleDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Catalogue Page");
        model.addAttribute("categoriesArticles", categorieArticleDAO.getAllCategories());
        return "integrated:catalogue";
    }

}
