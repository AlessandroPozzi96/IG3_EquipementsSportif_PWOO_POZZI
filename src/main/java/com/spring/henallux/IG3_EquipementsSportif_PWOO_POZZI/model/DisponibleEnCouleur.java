package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DisponibleEnCouleur {
    @NotNull
    @Size(max = 40, min = 1)
    private String couleur_fk;

    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer codeBarre_fk;

    public DisponibleEnCouleur() {
    }

    public String getCouleur_fk() {
        return couleur_fk;
    }

    public void setCouleur_fk(String couleur_fk) {
        this.couleur_fk = couleur_fk;
    }

    public Integer getCodeBarre_fk() {
        return codeBarre_fk;
    }

    public void setCodeBarre_fk(Integer codeBarre_fk) {
        this.codeBarre_fk = codeBarre_fk;
    }
}
