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

    @Column(name = "PRIX")
    private Double prix;

    @JoinColumn(name = "ID_CATEGORIE_FK", referencedColumnName = "ID")
    @ManyToOne
    private CategorieArticleEntity categorieArticleEntity;

    @OneToMany(mappedBy = "articleEntity")
    private Collection<ImageEntity> imageEntities;

    @OneToMany(mappedBy = "typeArticleEntity")
    private Collection<DisponibleEntity> disponibleEntities;

    @OneToMany(mappedBy = "typeArticleEntity")
    private Collection<DisponibleEnCouleurEntity> disponibleEnCouleurEntities;

    @OneToMany(mappedBy = "typeArticleEntity")
    private Collection<LigneCommandeEntity> ligneCommandeEntities;

    @OneToMany(mappedBy = "typeArticleEntity")
    private Collection<TranslationArticleEntity> translationArticleEntities;

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

    public CategorieArticleEntity getCategorieArticleEntity() {
        return categorieArticleEntity;
    }

    public void setCategorieArticleEntity(CategorieArticleEntity categorieArticleEntity) {
        this.categorieArticleEntity = categorieArticleEntity;
    }

    public Collection<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(Collection<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public Collection<DisponibleEntity> getDisponibleEntities() {
        return disponibleEntities;
    }

    public void setDisponibleEntities(Collection<DisponibleEntity> disponibleEntities) {
        this.disponibleEntities = disponibleEntities;
    }

    public Collection<DisponibleEnCouleurEntity> getDisponibleEnCouleurEntities() {
        return disponibleEnCouleurEntities;
    }

    public void setDisponibleEnCouleurEntities(Collection<DisponibleEnCouleurEntity> disponibleEnCouleurEntities) {
        this.disponibleEnCouleurEntities = disponibleEnCouleurEntities;
    }

    public Collection<LigneCommandeEntity> getLigneCommandeEntities() {
        return ligneCommandeEntities;
    }

    public void setLigneCommandeEntities(Collection<LigneCommandeEntity> ligneCommandeEntities) {
        this.ligneCommandeEntities = ligneCommandeEntities;
    }

    public Collection<TranslationArticleEntity> getTranslationArticleEntities() {
        return translationArticleEntities;
    }

    public void setTranslationArticleEntities(Collection<TranslationArticleEntity> translationArticleEntities) {
        this.translationArticleEntities = translationArticleEntities;
    }
}
