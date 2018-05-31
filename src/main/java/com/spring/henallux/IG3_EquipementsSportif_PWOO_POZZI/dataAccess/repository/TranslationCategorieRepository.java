package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCategorieEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCategoriePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationCategorieRepository extends JpaRepository<TranslationCategorieEntity, TranslationCategoriePK> {
    @Query("select translationCategorie from TranslationCategorieEntity translationCategorie where translationCategorie.translationCategoriePK.idCategorie_FK = ?1 and translationCategorie.translationCategoriePK.langageID_FK = ?2")
    TranslationCategorieEntity findByTranslationCategoriePK_IdCategorie_FKAndTranslationCategoriePK_LangageID_FK(Integer idCategorie, String langageID);
}
