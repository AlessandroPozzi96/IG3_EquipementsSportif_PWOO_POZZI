package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategorieArticle {
    @NotNull
    @Size
    private Integer id;
    @NotNull
    @Size(min = 1, max = 200)
    private String url_image;

    public CategorieArticle() {
    }

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
}
