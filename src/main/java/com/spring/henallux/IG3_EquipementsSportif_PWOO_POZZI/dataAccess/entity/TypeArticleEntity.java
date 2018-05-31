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

    @OneToMany(mappedBy = "articleEntity", fetch = FetchType.LAZY)
    private Collection<ImageEntity> imageEntities;

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
}
