package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TypeArticle {
    @NotNull
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private Integer codeBarre;
    @NotNull
    @Size(min = 1, max = 50)
    private String libelle_fr;
    @NotNull
    @Size(min = 1, max = 50)
    private String libelle_en;
    @NotNull
    @Size(min = 1, max = 200)
    private String description_fr;
    @NotNull
    @Size(max = 200, min = 1)
    private String description_en;
    @NotNull
    private Double prix;
    @NotNull
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private Integer id_categorie_fk;
    @NotNull
    @Size(min = 1, max = 200)
    private String url_image_fk;

    public TypeArticle() {
    }

    public Integer getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
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

    public String getDescription_fr() {
        return description_fr;
    }

    public void setDescription_fr(String description_fr) {
        this.description_fr = description_fr;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
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

    public String getUrl_image_fk() {
        return url_image_fk;
    }

    public void setUrl_image_fk(String url_image_fk) {
        this.url_image_fk = url_image_fk;
    }
}
