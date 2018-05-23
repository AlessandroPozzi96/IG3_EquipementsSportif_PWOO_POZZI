package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategorieArticle {
    @NotNull
    @Size
    private Integer id;
    @NotNull
    @Size(min = 1, max = 50)
    private String libelle_fr;
    @NotNull
    @Size(min = 1, max = 50)
    private String libelle_en;

    public CategorieArticle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle_fr() {
        return libelle_fr;
    }

    public void setLibelle_fr(String libelle_fr) {
        this.libelle_fr = libelle_fr;
    }

    public String getLibelle_en() {
        return libelle_en;
    }

    public void setLibelle_en(String libelle_en) {
        this.libelle_en = libelle_en;
    }
}
