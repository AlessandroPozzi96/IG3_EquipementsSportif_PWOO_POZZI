package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DisponibleEnCouleurPK implements Serializable {
    @Column(name = "COULEUR_FK")
    private Integer couleur_fk;

    @Column(name = "CODEBARRE_FK")
    private Integer codeBarre_fk;

    public DisponibleEnCouleurPK() {
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
