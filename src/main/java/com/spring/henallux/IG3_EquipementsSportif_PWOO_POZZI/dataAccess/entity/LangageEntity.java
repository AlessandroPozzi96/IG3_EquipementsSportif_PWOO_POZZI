package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LANGAGE")
public class LangageEntity {
    @Id
    @Column(name = "LANGAGEID")
    private String langageID;

    public String getLangageID() {
        return langageID;
    }

    public void setLangageID(String langageID) {
        this.langageID = langageID;
    }
}
