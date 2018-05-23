package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TYPEARTICLE")
public class TypeArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODEBARRE")
    private Integer codeBarre;

    @Column(name = "LIBELLE_FR")
    private String libelle_fr;

    @Column(name = "LIBELLE_EN")
    private String libelle_en;

    @Column(name = "DESCRIPTION_FR")
    private String description_fr;

    @Column(name = "DESCRIPTION_EN")
    private String description_en;

    @Column(name = "PRIX")
    private Double prix;


}
