package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONCATEGORIE")
public class TranslationCategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;
    @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID")
    @ManyToOne
    private LangageEntity langageEntity;

    @JoinColumn(name = "IDCATEGORIE_FK", referencedColumnName = "ID")
    @ManyToOne
    private CategorieArticleEntity categorieArticleEntity;

    @Column(name = "LIBELLE")
    private String libelle;

    public LangageEntity getLangageEntity() {
        return langageEntity;
    }

    public void setLangageEntity(LangageEntity langageEntity) {
        this.langageEntity = langageEntity;
    }

    public CategorieArticleEntity getCategorieArticleEntity() {
        return categorieArticleEntity;
    }

    public void setCategorieArticleEntity(CategorieArticleEntity categorieArticleEntity) {
        this.categorieArticleEntity = categorieArticleEntity;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
