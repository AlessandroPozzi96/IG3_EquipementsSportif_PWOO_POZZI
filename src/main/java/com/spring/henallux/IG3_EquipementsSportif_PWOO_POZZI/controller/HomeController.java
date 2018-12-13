package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
@SessionAttributes({Constants.PANIER})
public class HomeController {

    @ModelAttribute(Constants.PANIER)
    public Panier getNbArticles() {
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "integrated:home";
    }
}
