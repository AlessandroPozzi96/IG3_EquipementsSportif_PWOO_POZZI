package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DISPONIBLE")
public class DisponibleEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "TAILLE_FK", referencedColumnName = "TAILLEARTICLE"),
            @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    })
    private DisponiblePK disponiblePK;

    public DisponiblePK getDisponiblePK() {
        return disponiblePK;
    }

    public void setDisponiblePK(DisponiblePK disponiblePK) {
        this.disponiblePK = disponiblePK;
    }
}

