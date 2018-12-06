package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DISPONIBLE")
public class DisponibleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;

    @JoinColumn(name = "TAILLE_FK", referencedColumnName = "TAILLEARTICLE")
    @ManyToOne
    private TailleEntity tailleEntity;

    @JoinColumn(name = "CODEBARRE_FK", referencedColumnName = "CODEBARRE")
    @ManyToOne
    private TypeArticleEntity typeArticleEntity;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public TailleEntity getTailleEntity() {
        return tailleEntity;
    }

    public void setTailleEntity(TailleEntity tailleEntity) {
        this.tailleEntity = tailleEntity;
    }

    public TypeArticleEntity getTypeArticleEntity() {
        return typeArticleEntity;
    }

    public void setTypeArticleEntity(TypeArticleEntity typeArticleEntity) {
        this.typeArticleEntity = typeArticleEntity;
    }
}

