package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TypeArticle {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer codeBarre;
    @NotNull
    private Double prix;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer id_categorie_fk;

    public TypeArticle() {
    }

    public Integer getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getId_categorie_fk() {
        return id_categorie_fk;
    }

    public void setId_categorie_fk(Integer id_categorie_fk) {
        this.id_categorie_fk = id_categorie_fk;
    }
}
