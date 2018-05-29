package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes({Constants.PANIER})
public class GlobalControllerAdvice {
    //Controller qui va diffuser le même model attribute dans toute les autres controller afin que le nombre d'panier soit mis à jour dans la bannière
    private Panier panier = new Panier();
        @ModelAttribute(Constants.PANIER)
    public Panier getNbArticles() {
       return panier;
    }
}
