package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TranslationCouleurEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.TranslationCouleurRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TranslationCouleur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationCouleurDAO {
    private TranslationCouleurRepository translationCouleurRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationCouleurDAO(TranslationCouleurRepository translationCouleurRepository, ProviderConverter providerConverter) {
        this.translationCouleurRepository = translationCouleurRepository;
        this.providerConverter = providerConverter;
    }

    public TranslationCouleur findByTranslationCouleurPK_IdCouleur_FKAndTranslationCouleurPK_LangageID_FK(Integer idCouleur, String langageID) {
        TranslationCouleurEntity translationCouleurEntity = translationCouleurRepository.findByTranslationCouleurPK_IdCouleur_FKAndTranslationCouleurPK_LangageID_FK(idCouleur, langageID);
        TranslationCouleur translationCouleur = providerConverter.translationCouleurEntityToTranslationCouleurModel(translationCouleurEntity);

        return translationCouleur;
    }

    public TranslationCouleur findByLibelleAndAndTranslationCouleurPK_LangageID_FK(String libelle, String langageID) {
        TranslationCouleurEntity translationCouleurEntity = translationCouleurRepository.findByLibelleAndAndTranslationCouleurPK_LangageID_FK(libelle, langageID);
        TranslationCouleur translationCouleur = providerConverter.translationCouleurEntityToTranslationCouleurModel(translationCouleurEntity);

        return translationCouleur;
    }
}
