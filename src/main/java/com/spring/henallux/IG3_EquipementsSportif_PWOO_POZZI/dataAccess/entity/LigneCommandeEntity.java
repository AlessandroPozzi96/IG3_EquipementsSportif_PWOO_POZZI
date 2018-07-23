package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "LIGNECOMMANDE")
public class LigneCommandeEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE"),
            @JoinColumn(name = "NUMTICKET_FK", referencedColumnName = "NUMTICKET")
    })
    private LigneCommandePK ligneCommandePK;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "PRIXREEL")
    private Double prixReel;

    public LigneCommandePK getLigneCommandePK() {
        return ligneCommandePK;
    }

    public void setLigneCommandePK(LigneCommandePK ligneCommandePK) {
        this.ligneCommandePK = ligneCommandePK;
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
