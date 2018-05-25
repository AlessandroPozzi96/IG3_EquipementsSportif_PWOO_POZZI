package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

public class LignePanier {
    private String libelle;
    private Integer quantite;
    private Double prix;
    private Double prixUnitaire;
    private Integer codeBarre;
    //Penser a ajouter plus d'infos comme le code barre.

    public LignePanier(Integer codeBarre, String libelle, Integer quantite, Double prix, Double prixUnitaire) {
        this.codeBarre = codeBarre;
        this.libelle = libelle;
        this.quantite = quantite;
        this.prix = prix;
        this.prixUnitaire = prixUnitaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
    }
}
