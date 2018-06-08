package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONCOULEUR")
public class TranslationCouleurEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID"),
            @JoinColumn(name = "IDCOULEUR_FK", referencedColumnName = "ID")
    })
    private TranslationCouleurPK translationCouleurPK;
    @Column(name = "LIBELLE")
    private String libelle;

    public TranslationCouleurPK getTranslationCouleurPK() {
        return translationCouleurPK;
    }

    public void setTranslationCouleurPK(TranslationCouleurPK translationCouleurPK) {
        this.translationCouleurPK = translationCouleurPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
