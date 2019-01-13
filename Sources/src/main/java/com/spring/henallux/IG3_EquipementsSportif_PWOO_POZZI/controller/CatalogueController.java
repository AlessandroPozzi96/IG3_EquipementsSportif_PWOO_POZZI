package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.CategorieArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TranslationCategorieDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.CategorieArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController {
    private CategorieArticleDAO categorieArticleDAO;
    private TranslationCategorieDAO translationCategorieDAO;
    private ArrayList<CategorieArticle> categorieArticles;

    @Autowired
    public CatalogueController(CategorieArticleDAO categorieArticleDAO, TranslationCategorieDAO translationCategorieDAO) {
        this.categorieArticleDAO = categorieArticleDAO;
        this.translationCategorieDAO = translationCategorieDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        categorieArticles = categorieArticleDAO.getAllCategories();
        model.addAttribute("categoriesArticles", categorieArticles);
        model.addAttribute("translationCategorieDAO", translationCategorieDAO);

        return "integrated:catalogue";
    }

}