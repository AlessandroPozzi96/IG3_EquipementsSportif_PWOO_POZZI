package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONARTICLE")
public class TranslationArticleEntity {
    @EmbeddedId
    @JoinColumns({
            @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID"),
            @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    })
    private TranslationArticlePK translationArticlePK;

    @Column(name = "LIBELLE")
    private String libelle;

    @Column(name = "DESCRIPTION")
    private String description;

    public TranslationArticlePK getTranslationArticlePK() {
        return translationArticlePK;
    }

    public void setTranslationArticlePK(TranslationArticlePK translationArticlePK) {
        this.translationArticlePK = translationArticlePK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
