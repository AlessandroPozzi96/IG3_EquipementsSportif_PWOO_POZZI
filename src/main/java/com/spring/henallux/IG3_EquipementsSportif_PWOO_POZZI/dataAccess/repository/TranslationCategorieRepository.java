package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationCategorieRepository extends JpaRepository<TranslationCategorieEntity, Integer> {
    TranslationCategorieEntity findByCategorieArticleEntity_IdAndLangageEntity_LangageID(Integer idCategorie, String langageID);
}
