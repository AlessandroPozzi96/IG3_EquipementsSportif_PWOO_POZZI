package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAILLE")
public class TailleEntity {
    @Id
    @Column(name = "TAILLEARTICLE")
    private String tailleArticle;

    public String getTailleArticle() {
        return tailleArticle;
    }

    public void setTailleArticle(String tailleArticle) {
        this.tailleArticle = tailleArticle;
    }
}
