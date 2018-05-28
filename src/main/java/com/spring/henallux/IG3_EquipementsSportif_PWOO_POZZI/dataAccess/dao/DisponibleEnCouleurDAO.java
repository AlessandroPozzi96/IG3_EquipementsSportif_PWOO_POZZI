package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEnCouleurEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.DisponibleEnCouleurRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.DisponibleEnCouleur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisponibleEnCouleurDAO {
    private DisponibleEnCouleurRepository disponibleEnCouleurRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public DisponibleEnCouleurDAO(DisponibleEnCouleurRepository disponibleEnCouleurRepository, ProviderConverter providerConverter) {
        this.disponibleEnCouleurRepository = disponibleEnCouleurRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<DisponibleEnCouleur> findAllByCodeBarre(Integer codeBarre) {
        List<DisponibleEnCouleurEntity> disponibleEntities = disponibleEnCouleurRepository.findAllByCodeBarre(codeBarre);
        ArrayList<DisponibleEnCouleur> disponibleArrayList = new ArrayList<>();
        for (DisponibleEnCouleurEntity entity : disponibleEntities) {
            DisponibleEnCouleur disponibleEnCouleur = providerConverter.disponibleEnCouleurEntityToDisponibleEnCouleurModel(entity);
            disponibleArrayList.add(disponibleEnCouleur);
        }
        return disponibleArrayList;
    }
}
