package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TranslationArticlePK implements Serializable {
    @Column(name = "LANGAGEID_FK")
    private String langageID_FK;
    @Column(name = "CODEBARRE_FK")
    private Integer codeBarre_FK;

    public TranslationArticlePK() {
    }

    public String getLangageID_FK() {
        return langageID_FK;
    }

    public void setLangageID_FK(String langageID_FK) {
        this.langageID_FK = langageID_FK;
    }

    public Integer getCodeBarre_FK() {
        return codeBarre_FK;
    }

    public void setCodeBarre_FK(Integer codeBarre_FK) {
        this.codeBarre_FK = codeBarre_FK;
    }
}
