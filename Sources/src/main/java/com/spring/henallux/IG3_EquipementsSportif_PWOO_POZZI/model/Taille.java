package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taille {
    @NotNull
    @Size(min = 1, max = 4)
    private String tailleArticle;

    public Taille() {
    }

    public String getTailleArticle() {
        return tailleArticle;
    }

    public void setTailleArticle(String tailleArticle) {
        this.tailleArticle = tailleArticle;
    }
}
