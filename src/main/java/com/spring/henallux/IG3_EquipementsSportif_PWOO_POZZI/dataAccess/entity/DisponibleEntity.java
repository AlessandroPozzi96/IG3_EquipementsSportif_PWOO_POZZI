package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISPONIBLE")
public class DisponibleEntity {
    @EmbeddedId
    private DisponiblePK disponiblePK;

    public DisponiblePK getDisponiblePK() {
        return disponiblePK;
    }

    public void setDisponiblePK(DisponiblePK disponiblePK) {
        this.disponiblePK = disponiblePK;
    }
}
