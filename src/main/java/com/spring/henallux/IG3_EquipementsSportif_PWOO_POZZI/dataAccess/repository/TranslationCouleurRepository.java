package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCouleurEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCouleurPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationCouleurRepository extends JpaRepository<TranslationCouleurEntity, TranslationCouleurPK> {
    @Query("select translationCouleur from TranslationCouleurEntity translationCouleur where translationCouleur.translationCouleurPK.idCouleur_FK = ?1 and translationCouleur.translationCouleurPK.langageID_FK = ?2")
    TranslationCouleurEntity findByTranslationCouleurPK_IdCouleur_FKAndTranslationCouleurPK_LangageID_FK(Integer idCouleur, String langageID);
}
