package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCouleurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationCouleurRepository extends JpaRepository<TranslationCouleurEntity, Integer> {
    TranslationCouleurEntity findByCouleurEntity_IdAndLangageEntity_LangageID(Integer idCouleur, String langageID);
    TranslationCouleurEntity findByLibelleAndLangageEntity_LangageID(String libelle, String langageID);
}
