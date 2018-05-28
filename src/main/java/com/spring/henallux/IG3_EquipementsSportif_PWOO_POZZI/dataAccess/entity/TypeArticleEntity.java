package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TYPEARTICLE")
public class TypeArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODEBARRE")
    private Integer codeBarre;

    @Column(name = "LIBELLE_FR")
    private String libelle_fr;

    @Column(name = "LIBELLE_EN")
    private String libelle_en;

    @Column(name = "DESCRIPTION_FR")
    private String description_fr;

    @Column(name = "DESCRIPTION_EN")
    private String description_en;

    @Column(name = "PRIX")
    private Double prix;

    @JoinColumn(name = "ID_CATEGORIE_FK", referencedColumnName = "ID")
    @ManyToOne
    private CategorieArticleEntity categorieArticleEntity;

    @OneToMany(mappedBy = "articleEntity", fetch = FetchType.LAZY)
    private Collection<ImageEntity> imageEntities;

    @OneToMany(mappedBy = "disponiblePK", fetch = FetchType.LAZY)
    private Collection<DisponibleEntity> disponibleEntities;

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

    public CategorieArticleEntity getCategorieArticleEntity() {
        return categorieArticleEntity;
    }

    public void setCategorieArticleEntity(CategorieArticleEntity categorieArticleEntity) {
        this.categorieArticleEntity = categorieArticleEntity;
    }
}
