package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COULEUR")
public class CouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @OneToMany(mappedBy = "couleurEntity")
    private Collection<DisponibleEnCouleurEntity> disponibleEnCouleurEntities;

    @OneToMany(mappedBy = "couleurEntity")
    private Collection<TranslationCouleurEntity> translationCouleurEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
