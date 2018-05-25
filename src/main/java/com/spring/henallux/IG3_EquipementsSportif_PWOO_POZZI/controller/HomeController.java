package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
//@SessionAttributes({Constants.NB_ARTICLES})
public class HomeController {
/*    @ModelAttribute(Constants.NB_ARTICLES)
    public Article getNbArticles() {
        return new Article();
    }*/
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        return "integrated:home";
    }
}
