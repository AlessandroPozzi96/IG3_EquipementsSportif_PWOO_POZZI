package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ELEMENTSPANIER")
public class ElementsPanierEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE"),
            @JoinColumn(name = "NUMTICKET_FK", referencedColumnName = "NUMTICKET")
    })
    private ElementsPanierPK elementsPanierPK;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "PRIXREEL")
    private Double prixReel;

    public ElementsPanierPK getElementsPanierPK() {
        return elementsPanierPK;
    }

    public void setElementsPanierPK(ElementsPanierPK elementsPanierPK) {
        this.elementsPanierPK = elementsPanierPK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixReel() {
        return prixReel;
    }

    public void setPrixReel(Double prixReel) {
        this.prixReel = prixReel;
    }
}
