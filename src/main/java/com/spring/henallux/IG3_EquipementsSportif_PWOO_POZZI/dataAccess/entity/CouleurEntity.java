package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COULEUR")
public class CouleurEntity {
    @Id
    @Column(name = "COULEURARTICLE")
    private String couleurArticle;

    @Column(name = "LIBELLE_EN")
    private String libelle_en;

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
