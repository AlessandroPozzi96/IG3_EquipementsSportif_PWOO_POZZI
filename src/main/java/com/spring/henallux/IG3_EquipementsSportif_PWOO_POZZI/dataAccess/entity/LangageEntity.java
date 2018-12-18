package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LANGAGE")
public class LangageEntity {
    @Id
    @Column(name = "LANGAGEID")
    private String langageID;

    @OneToMany(mappedBy = "langageEntity")
    private Collection<TranslationCategorieEntity> translationCategorieEntities;

    @OneToMany(mappedBy = "langageEntity")
    private Collection<TranslationArticleEntity> translationArticleEntities;

    @OneToMany(mappedBy = "langageEntity")
    private Collection<TranslationCouleurEntity> translationCouleurEntities;

    public String getLangageID() {
        return langageID;
    }

    public void setLangageID(String langageID) {
        this.langageID = langageID;
    }

    public Collection<TranslationCategorieEntity> getTranslationCategorieEntities() {
        return translationCategorieEntities;
    }

    public void setTranslationCategorieEntities(Collection<TranslationCategorieEntity> translationCategorieEntities) {
        this.translationCategorieEntities = translationCategorieEntities;
    }

    public Collection<TranslationArticleEntity> getTranslationArticleEntities() {
        return translationArticleEntities;
    }

    public void setTranslationArticleEntities(Collection<TranslationArticleEntity> translationArticleEntities) {
        this.translationArticleEntities = translationArticleEntities;
    }

    public Collection<TranslationCouleurEntity> getTranslationCouleurEntities() {
        return translationCouleurEntities;
    }

    public void setTranslationCouleurEntities(Collection<TranslationCouleurEntity> translationCouleurEntities) {
        this.translationCouleurEntities = translationCouleurEntities;
    }
}
