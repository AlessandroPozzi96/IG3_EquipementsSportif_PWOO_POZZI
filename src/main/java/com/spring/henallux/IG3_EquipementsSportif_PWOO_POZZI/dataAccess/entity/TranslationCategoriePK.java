package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TranslationCategoriePK implements Serializable {
    @Column(name = "LANGAGEID_FK")
    private String langageID_FK;
    @Column(name = "IDCATEGORIE_FK")
    private Integer idCategorie_FK;

    public TranslationCategoriePK() {
    }

    public String getLangageID_FK() {
        return langageID_FK;
    }

    public void setLangageID_FK(String langageID_FK) {
        this.langageID_FK = langageID_FK;
    }

    public Integer getIdCategorie_FK() {
        return idCategorie_FK;
    }

    public void setIdCategorie_FK(Integer idCategorie_FK) {
        this.idCategorie_FK = idCategorie_FK;
    }
}
