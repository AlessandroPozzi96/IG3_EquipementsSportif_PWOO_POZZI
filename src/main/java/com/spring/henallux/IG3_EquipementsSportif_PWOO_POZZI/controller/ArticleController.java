package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.ImageDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ArticleValidator;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/article")
@SessionAttributes({Constants.NB_ARTICLES})
public class ArticleController {
    private TypeArticleDAO typeArticleDAO;
    private ImageDAO imageDAO;
    private Integer cb;
    private ArticleValidator articleValidator;

    @Autowired
    public ArticleController(TypeArticleDAO typeArticleDAO, ImageDAO imageDAO, ArticleValidator articleValidator) {
        this.typeArticleDAO = typeArticleDAO;
        this.imageDAO = imageDAO;
        this.articleValidator = articleValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(required = true, defaultValue = "1") Integer codeBarre, Model model) {
        model.addAttribute("title", "Article Page");
        model.addAttribute("article", typeArticleDAO.findByCodeBarre(codeBarre));
        model.addAttribute("images", imageDAO.findByArticleEntityCodeBarre(codeBarre));
        cb = codeBarre;
        return "integrated:article";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getArticle(Model model, @Valid @ModelAttribute(Constants.NB_ARTICLES)Article articles, BindingResult result) {
        articleValidator.validate(articles, result);
        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "integrated:error";
        }
        try {
            articles.addArticlesPanier(cb, articles.getNbArticles());
            System.out.println("DANS LE TRY CATCH");
        } catch (ModelException e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
        System.out.println("Nb articles commander : " + articles.getNbArticlesPanier());
        return "redirect:/panier";
    }
}
