package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONCATEGORIE")
public class TranslationCategorieEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID"),
            @JoinColumn(name = "IDCATEGORIE_FK", referencedColumnName = "ID")
    })
    private TranslationCategoriePK translationCategoriePK;

    @Column(name = "LIBELLE")
    private String libelle;

    public TranslationCategoriePK getTranslationCategoriePK() {
        return translationCategoriePK;
    }

    public void setTranslationCategoriePK(TranslationCategoriePK translationCategoriePK) {
        this.translationCategoriePK = translationCategoriePK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
