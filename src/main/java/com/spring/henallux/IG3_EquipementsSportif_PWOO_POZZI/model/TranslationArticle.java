package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TranslationArticle {
    @NotNull
    @Min(1)
    @Max(99999999)
    private Integer Id;
    @NotNull
    @Size(min = 1, max = 6)
    private String langageID_FK;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer codeBarre_FK;
    @NotNull
    @Size(min = 1, max = 200)
    private String libelle;
    @NotNull
    @Size(min = 1, max = 400)
    private String description;

    public TranslationArticle() {
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

    public Integer getCodeBarre_FK() {
        return codeBarre_FK;
    }

    public void setCodeBarre_FK(Integer codeBarre_FK) {
        this.codeBarre_FK = codeBarre_FK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
