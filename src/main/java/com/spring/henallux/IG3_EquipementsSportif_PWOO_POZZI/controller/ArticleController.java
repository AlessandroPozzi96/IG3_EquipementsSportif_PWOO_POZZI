package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.ImageDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    private TypeArticleDAO typeArticleDAO;
    private ImageDAO imageDAO;

    @Autowired
    public ArticleController(TypeArticleDAO typeArticleDAO, ImageDAO imageDAO) {
        this.typeArticleDAO = typeArticleDAO;
        this.imageDAO = imageDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(required = true, defaultValue = "1") Integer codeBarre, Model model) {
        model.addAttribute("title", "Article Page");
        model.addAttribute("article", typeArticleDAO.findByCodeBarre(codeBarre));
        model.addAttribute("images", imageDAO.findByArticleEntityCodeBarre(codeBarre));
        return "integrated:article";
    }
}
