package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {
    //Controller qui va diffuser le même model attribute dans toute les autres controller afin que le nombre d'article soit mis à jour dans la bannière
    private Article article = new Article();
        @ModelAttribute(Constants.NB_ARTICLES)
    public Article getNbArticles() {
       return article;
    }
}
