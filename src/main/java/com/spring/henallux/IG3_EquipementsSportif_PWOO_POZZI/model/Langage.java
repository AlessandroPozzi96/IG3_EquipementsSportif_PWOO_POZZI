package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Langage {
    @NotNull
    @Size(min = 1, max = 6)
    private String langageID;

    public Langage() {
    }

    public String getLangageID() {
        return langageID;
    }

    public void setLangageID(String langageID) {
        this.langageID = langageID;
    }
}
