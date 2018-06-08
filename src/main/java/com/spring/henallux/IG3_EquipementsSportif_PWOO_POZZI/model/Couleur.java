package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Couleur {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer id;

    public Couleur() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
