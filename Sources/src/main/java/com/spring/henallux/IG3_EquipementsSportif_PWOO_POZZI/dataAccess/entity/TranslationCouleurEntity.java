package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONCOULEUR")
public class TranslationCouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;
    @JoinColumn(name = "LANGAGEID_FK", referencedColumnName = "LANGAGEID")
    @ManyToOne
    private LangageEntity langageEntity;

    @JoinColumn(name = "IDCOULEUR_FK", referencedColumnName = "ID")
    @ManyToOne
    private CouleurEntity couleurEntity;

    @Column(name = "LIBELLE")
    private String libelle;

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

    public CouleurEntity getCouleurEntity() {
        return couleurEntity;
    }

    public void setCouleurEntity(CouleurEntity couleurEntity) {
        this.couleurEntity = couleurEntity;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
