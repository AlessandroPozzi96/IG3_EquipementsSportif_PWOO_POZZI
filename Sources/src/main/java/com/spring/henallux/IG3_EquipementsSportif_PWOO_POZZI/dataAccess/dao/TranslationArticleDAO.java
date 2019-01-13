package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.TranslationArticleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TranslationArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationArticleDAO {
    private ProviderConverter providerConverter;
    private TranslationArticleRepository translationArticleRepository;

    @Autowired
    public TranslationArticleDAO(ProviderConverter providerConverter, TranslationArticleRepository translationArticleRepository) {
        this.providerConverter = providerConverter;
        this.translationArticleRepository = translationArticleRepository;
    }

    public TranslationArticle findByTranslationArticlePK_CodeBarre_FKAndTranslationArticlePK_LangageID_FK(Integer codeBarre, String lang) {
        TranslationArticleEntity translationArticleEntity = translationArticleRepository.findByTypeArticleEntity_CodeBarreAndLangageEntity_LangageID(codeBarre, lang);
        TranslationArticle translationArticle = providerConverter.translationArticleEntityToTranslationArticleModel(translationArticleEntity);

        return translationArticle;
    }
}
