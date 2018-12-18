package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONARTICLE")
public class TranslationArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;
    @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID")
    @ManyToOne
    private LangageEntity langageEntity;

    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private TypeArticleEntity typeArticleEntity;

    @Column(name = "LIBELLE")
    private String libelle;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LangageEntity getLangageEntity() {
        return langageEntity;
    }

    public void setLangageEntity(LangageEntity langageEntity) {
        this.langageEntity = langageEntity;
    }

    public TypeArticleEntity getTypeArticleEntity() {
        return typeArticleEntity;
    }

    public void setTypeArticleEntity(TypeArticleEntity typeArticleEntity) {
        this.typeArticleEntity = typeArticleEntity;
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
