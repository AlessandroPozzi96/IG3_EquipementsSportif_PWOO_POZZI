package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TranslationCategorie {
    @NotNull
    @Size(min = 1, max = 6)
    private String langageID_FK;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer idCategorie_FK;
    @NotNull
    @Size(min = 1, max = 200)
    private String libelle;

    public TranslationCategorie() {
    }

    public String getLangageID_FK() {
        return langageID_FK;
    }

    public void setLangageID_FK(String langageID_FK) {
        this.langageID_FK = langageID_FK;
    }

    public Integer getIdCategorie_FK() {
        return idCategorie_FK;
    }

    public void setIdCategorie_FK(Integer idCategorie_FK) {
        this.idCategorie_FK = idCategorie_FK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
