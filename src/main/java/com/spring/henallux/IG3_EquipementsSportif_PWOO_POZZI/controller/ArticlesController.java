package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.ImageDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TranslationArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.TranslationArticleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/articles")
public class ArticlesController {
    private TypeArticleDAO typeArticleDAO;
    private ImageDAO imageDAO;
    private TranslationArticleDAO translationArticleDAO;
    private ArrayList<TypeArticle> typeArticles;

    @Autowired
    public ArticlesController(TypeArticleDAO typeArticleDAO, ImageDAO imageDAO, TranslationArticleDAO translationArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
        this.imageDAO = imageDAO;
        this.translationArticleDAO = translationArticleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public String home(@RequestParam(required = true, defaultValue = "1") Integer id, Model model) {
        typeArticles = typeArticleDAO.findByCategorieArticleEntityId(id);
        model.addAttribute("articles", typeArticles);
        model.addAttribute("imageDAO", imageDAO);
        model.addAttribute("translationArticleDAO", translationArticleDAO);

        return "integrated:articles";
    }
}
