package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
//@SessionAttributes({Constants.NB_ARTICLES})
public class HomeController {
/*    @ModelAttribute(Constants.NB_ARTICLES)
    public Panier getNbArticles() {
        return new Panier();
    }*/
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:home";
    }
}
