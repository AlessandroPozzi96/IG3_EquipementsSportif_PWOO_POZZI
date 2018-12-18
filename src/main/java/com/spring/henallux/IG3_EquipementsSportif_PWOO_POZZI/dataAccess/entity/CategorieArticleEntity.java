package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CATEGORIEARTICLE")
public class CategorieArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "URL_IMAGE")
    private String url_image;

    @OneToMany(mappedBy = "categorieArticleEntity", fetch = FetchType.LAZY)
    private Collection<TypeArticleEntity> typeArticleEntities;

    @OneToMany(mappedBy = "categorieArticleEntity")
    private Collection<TranslationCategorieEntity> categorieArticleEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Collection<TypeArticleEntity> getTypeArticleEntities() {
        return typeArticleEntities;
    }

    public void setTypeArticleEntities(Collection<TypeArticleEntity> typeArticleEntities) {
        this.typeArticleEntities = typeArticleEntities;
    }

    public Collection<TranslationCategorieEntity> getCategorieArticleEntities() {
        return categorieArticleEntities;
    }

    public void setCategorieArticleEntities(Collection<TranslationCategorieEntity> categorieArticleEntities) {
        this.categorieArticleEntities = categorieArticleEntities;
    }
}
