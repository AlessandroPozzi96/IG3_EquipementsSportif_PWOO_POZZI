package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.LigneCommandeEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.LigneCommandeRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeDAO
{
    private LigneCommandeRepository ligneCommandeRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public LigneCommandeDAO(LigneCommandeRepository ligneCommandeRepository, ProviderConverter providerConverter) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.providerConverter = providerConverter;
    }

    public void saveLigneCommande(LigneCommande ligneCommande) {
        LigneCommandeEntity ligneCommandeEntity = providerConverter.ligneCommandeModelToLigneCommandeEntity(ligneCommande);
        ligneCommandeRepository.save(ligneCommandeEntity);
    }
}
