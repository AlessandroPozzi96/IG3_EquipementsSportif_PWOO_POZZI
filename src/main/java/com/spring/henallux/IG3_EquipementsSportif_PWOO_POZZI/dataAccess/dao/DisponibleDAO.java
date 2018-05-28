package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.DisponibleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Disponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisponibleDAO {
    private DisponibleRepository disponibleRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public DisponibleDAO(DisponibleRepository disponibleRepository, ProviderConverter providerConverter) {
        this.disponibleRepository = disponibleRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Disponible> getAllDisponible() {
        List<DisponibleEntity> disponibleEntities = disponibleRepository.findAll();
        ArrayList<Disponible> disponibleArrayList = new ArrayList<>();
        for (DisponibleEntity entity : disponibleEntities) {
            Disponible disponible = providerConverter.disponibleEntityToDisponibleModel(entity);
            disponibleArrayList.add(disponible);
        }
        return disponibleArrayList;
    }
}
