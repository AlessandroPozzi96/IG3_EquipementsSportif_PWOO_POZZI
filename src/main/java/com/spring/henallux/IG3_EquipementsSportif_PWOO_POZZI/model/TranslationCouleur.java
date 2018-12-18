package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TranslationCouleur {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer Id;
    @NotNull
    @Size(min = 1, max = 6)
    private String langageID_FK;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer idCouleur_FK;
    @NotNull
    @Size(max = 200, min = 1)
    private String libelle;

    public TranslationCouleur() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLangageID_FK() {
        return langageID_FK;
    }

    public void setLangageID_FK(String langageID_FK) {
        this.langageID_FK = langageID_FK;
    }

    public Integer getIdCouleur_FK() {
        return idCouleur_FK;
    }

    public void setIdCouleur_FK(Integer idCouleur_FK) {
        this.idCouleur_FK = idCouleur_FK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
