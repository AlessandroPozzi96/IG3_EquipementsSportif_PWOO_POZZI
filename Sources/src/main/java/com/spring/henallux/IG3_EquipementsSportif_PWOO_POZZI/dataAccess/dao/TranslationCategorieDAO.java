package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCategorieEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.TranslationCategorieRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TranslationCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationCategorieDAO {
    private TranslationCategorieRepository translationCategorieRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationCategorieDAO(TranslationCategorieRepository translationCategorieRepository, ProviderConverter providerConverter) {
        this.translationCategorieRepository = translationCategorieRepository;
        this.providerConverter = providerConverter;
    }

    public TranslationCategorie findByTranslationCategoriePK_IdCategorie_FKAndTranslationCategoriePK_LangageID_FK(Integer idCategorie, String langageID) {
        TranslationCategorieEntity translationCategorieEntity = translationCategorieRepository.findByCategorieArticleEntity_IdAndLangageEntity_LangageID(idCategorie, langageID);
        TranslationCategorie translationCategorie = providerConverter.translationCategorieEntityToTranslationCategorieModel(translationCategorieEntity);

        return translationCategorie;
    }
}
