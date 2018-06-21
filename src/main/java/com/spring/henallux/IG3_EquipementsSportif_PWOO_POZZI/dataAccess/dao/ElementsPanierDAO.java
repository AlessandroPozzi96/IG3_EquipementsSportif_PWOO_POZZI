package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.ElementsPanierEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.ElementsPanierRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.ElementsPanier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElementsPanierDAO
{
    private ElementsPanierRepository elementsPanierRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ElementsPanierDAO(ElementsPanierRepository elementsPanierRepository, ProviderConverter providerConverter) {
        this.elementsPanierRepository = elementsPanierRepository;
        this.providerConverter = providerConverter;
    }

    public void saveElementsPanier(ElementsPanier elementsPanier) {
        ElementsPanierEntity elementsPanierEntity = providerConverter.elementsPanierModelToElementsPanierEntity(elementsPanier);
        elementsPanierRepository.save(elementsPanierEntity);
    }
}
