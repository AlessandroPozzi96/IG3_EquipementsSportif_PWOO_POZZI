package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Couleur {
    @NotNull
    @Size(min = 1, max = 40)
    private String couleurArticle;
    @NotNull
    @Size(min = 1, max = 40)
    private String libelle_en;

    public Couleur() {
    }

    public String getCouleurArticle() {
        return couleurArticle;
    }

    public void setCouleurArticle(String couleurArticle) {
        this.couleurArticle = couleurArticle;
    }

    public String getLibelle_en() {
        return libelle_en;
    }

    public void setLibelle_en(String libelle_en) {
        this.libelle_en = libelle_en;
    }
}
