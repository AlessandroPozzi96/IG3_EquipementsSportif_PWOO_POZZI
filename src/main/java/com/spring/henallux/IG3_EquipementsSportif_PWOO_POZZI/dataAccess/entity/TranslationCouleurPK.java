package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TranslationCouleurPK implements Serializable {
    @Column(name = "LANGAGEID_FK")
    private String langageID_FK;
    @Column(name = "IDCOULEUR_FK")
    private Integer idCouleur_FK;

    public String getLangageID_FK() {
        return langageID_FK;
    }

    public void setLangageID_FK(String langageID_FK) {
        this.langageID_FK = langageID_FK;
    }

    public Integer getIdCouleur_FK() {
        return idCouleur_FK;
    }

    public void setIdCouleur_FK(Integer idCouleur_FK) {
        this.idCouleur_FK = idCouleur_FK;
    }
}
