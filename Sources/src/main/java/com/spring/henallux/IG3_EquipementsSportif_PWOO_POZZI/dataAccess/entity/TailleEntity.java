package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TAILLE")
public class TailleEntity {
    @Id
    @Column(name = "TAILLEARTICLE")
    private String tailleArticle;

    @OneToMany(mappedBy = "tailleEntity")
    private Collection<DisponibleEntity> disponibleEntities;

    public String getTailleArticle() {
        return tailleArticle;
    }

    public void setTailleArticle(String tailleArticle) {
        this.tailleArticle = tailleArticle;
    }

    public Collection<DisponibleEntity> getDisponibleEntities() {
        return disponibleEntities;
    }

    public void setDisponibleEntities(Collection<DisponibleEntity> disponibleEntities) {
        this.disponibleEntities = disponibleEntities;
    }
}
