package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISPONIBLEENCOULEUR")
public class DisponibleEnCouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;

    @JoinColumn(name = "COULEUR_FK", referencedColumnName = "ID")
    @ManyToOne
    private CouleurEntity couleurEntity;

    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private TypeArticleEntity typeArticleEntity;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public CouleurEntity getCouleurEntity() {
        return couleurEntity;
    }

    public void setCouleurEntity(CouleurEntity couleurEntity) {
        this.couleurEntity = couleurEntity;
    }

    public TypeArticleEntity getTypeArticleEntity() {
        return typeArticleEntity;
    }

    public void setTypeArticleEntity(TypeArticleEntity typeArticleEntity) {
        this.typeArticleEntity = typeArticleEntity;
    }
}
