package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class DisponiblePK implements Serializable {
    @JoinColumn(name = "TAILLE_FK", referencedColumnName = "TAILLEARTICLE")
    @ManyToOne
    private String taille_fk;

    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private Integer codeBarre_fk;

    public DisponiblePK() {
    }

    public String getTaille_fk() {
        return taille_fk;
    }

    public void setTaille_fk(String taille_fk) {
        this.taille_fk = taille_fk;
    }

    public Integer getCodeBarre_fk() {
        return codeBarre_fk;
    }

    public void setCodeBarre_fk(Integer codeBarre_fk) {
        this.codeBarre_fk = codeBarre_fk;
    }
}
