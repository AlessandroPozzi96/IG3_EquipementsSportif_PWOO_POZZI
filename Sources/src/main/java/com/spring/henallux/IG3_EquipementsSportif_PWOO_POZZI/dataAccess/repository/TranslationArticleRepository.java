package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationArticleRepository extends JpaRepository<TranslationArticleEntity, Integer> {
    TranslationArticleEntity findByTypeArticleEntity_CodeBarreAndLangageEntity_LangageID(Integer codeBarre, String lang);
}
