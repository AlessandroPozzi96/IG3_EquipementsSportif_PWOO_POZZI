package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ElementsPanier {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer quantite;
    @NotNull
    @Min(0)
    private Double prixReel;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer codeBarre_fk;
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer numTicket_fk;

    public ElementsPanier() {
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

    public Integer getCodeBarre_fk() {
        return codeBarre_fk;
    }

    public void setCodeBarre_fk(Integer codeBarre_fk) {
        this.codeBarre_fk = codeBarre_fk;
    }

    public Integer getNumTicket_fk() {
        return numTicket_fk;
    }

    public void setNumTicket_fk(Integer numTicket_fk) {
        this.numTicket_fk = numTicket_fk;
    }
}
