package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/articles")
public class ArticlesController {
    private TypeArticleDAO typeArticleDAO;

    @Autowired
    public ArticlesController(TypeArticleDAO typeArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(required = true, defaultValue = "1") Integer id, Model model) {
        model.addAttribute("title", "Articles Page");
        model.addAttribute("articles", typeArticleDAO.findByCategorieArticleEntityId(id));
        return "integrated:articles";
    }
}
