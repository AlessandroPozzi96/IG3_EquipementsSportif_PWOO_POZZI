package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class ImageEntity {
    @Id
    @Column(name = "URL")
    private String url;

    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private TypeArticleEntity articleEntity;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
