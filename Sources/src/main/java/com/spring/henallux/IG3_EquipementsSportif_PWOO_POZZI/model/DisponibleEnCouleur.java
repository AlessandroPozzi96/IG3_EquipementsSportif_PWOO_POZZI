package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DisponibleEnCouleur {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer Id;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer couleur_fk;

    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer codeBarre_fk;

    public DisponibleEnCouleur() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCouleur_fk() {
        return couleur_fk;
    }

    public void setCouleur_fk(Integer couleur_fk) {
        this.couleur_fk = couleur_fk;
    }

    public Integer getCodeBarre_fk() {
        return codeBarre_fk;
    }

    public void setCodeBarre_fk(Integer codeBarre_fk) {
        this.codeBarre_fk = codeBarre_fk;
    }
}
