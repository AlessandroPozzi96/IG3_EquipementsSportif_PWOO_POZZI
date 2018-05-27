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

    @Column(name = "LIBELLE_FR")
    private String libelle_fr;

    @Column(name = "LIBELLE_EN")
    private String libelle_en;

    @Column(name = "URL_IMAGE")
    private String url_image;

    @OneToMany(mappedBy = "categorieArticleEntity", fetch = FetchType.LAZY)
    private Collection<TypeArticleEntity> typeArticleEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
