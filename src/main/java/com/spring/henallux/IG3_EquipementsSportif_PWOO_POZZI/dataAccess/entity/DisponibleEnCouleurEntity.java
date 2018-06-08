package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISPONIBLEENCOULEUR")
public class DisponibleEnCouleurEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "COULEUR_FK", referencedColumnName = "ID"),
            @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    })
    private DisponibleEnCouleurPK disponibleEnCouleurPK;

    public DisponibleEnCouleurPK getDisponibleEnCouleurPK() {
        return disponibleEnCouleurPK;
    }

    public void setDisponibleEnCouleurPK(DisponibleEnCouleurPK disponibleEnCouleurPK) {
        this.disponibleEnCouleurPK = disponibleEnCouleurPK;
    }
}
