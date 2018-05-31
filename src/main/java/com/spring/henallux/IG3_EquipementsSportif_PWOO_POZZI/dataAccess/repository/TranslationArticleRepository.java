package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationArticlePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationArticleRepository extends JpaRepository<TranslationArticleEntity, TranslationArticlePK> {
    @Query("select translationArticle from TranslationArticleEntity translationArticle where translationArticle.translationArticlePK.codeBarre_FK = ?1 and translationArticle.translationArticlePK.langageID_FK = ?2")
    TranslationArticleEntity findByTranslationArticlePK_CodeBarre_FKAndTranslationArticlePK_LangageID_FK(Integer codeBarre, String lang);
}
