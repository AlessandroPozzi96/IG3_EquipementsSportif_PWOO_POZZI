package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "LIGNECOMMANDE")
public class LigneCommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;
    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private TypeArticleEntity typeArticleEntity;
    @JoinColumn(name = "NUMTICKET_FK", referencedColumnName = "NUMTICKET")
    @ManyToOne
    private CommandeEntity commandeEntity;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "PRIXREEL")
    private Double prixReel;
    @Column(name = "TAILLE_FK")
    private String taille_fk;
    @Column(name = "COULEUR_FK")
    private Integer couleur_fk;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getTaille_fk() {
        return taille_fk;
    }

    public void setTaille_fk(String taille_fk) {
        this.taille_fk = taille_fk;
    }

    public Integer getCouleur_fk() {
        return couleur_fk;
    }

    public void setCouleur_fk(Integer couleur_fk) {
        this.couleur_fk = couleur_fk;
    }

    public TypeArticleEntity getTypeArticleEntity() {
        return typeArticleEntity;
    }

    public void setTypeArticleEntity(TypeArticleEntity typeArticleEntity) {
        this.typeArticleEntity = typeArticleEntity;
    }

    public CommandeEntity getCommandeEntity() {
        return commandeEntity;
    }

    public void setCommandeEntity(CommandeEntity commandeEntity) {
        this.commandeEntity = commandeEntity;
    }
}
