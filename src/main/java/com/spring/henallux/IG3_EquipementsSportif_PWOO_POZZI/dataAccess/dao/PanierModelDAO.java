package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.PanierEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.PanierModelRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.PanierModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PanierModelDAO {
    private PanierModelRepository panierModelRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public PanierModelDAO(PanierModelRepository panierModelRepository, ProviderConverter providerConverter) {
        this.panierModelRepository = panierModelRepository;
        this.providerConverter = providerConverter;
    }

    public void savePanier(PanierModel panierModel, UserEntity userEntity) {
        PanierEntity panierEntity = providerConverter.panierModelToPanierEntity(panierModel, userEntity);
        panierModelRepository.save(panierEntity);
    }

    public Integer findLastNumTicket(String username) {
        List<PanierEntity> panierEntities = panierModelRepository.findAllByUserEntityUsername(username);
        Integer numTicketMax = 0;
        for (PanierEntity entity : panierEntities) {
            if (entity.getNumTicket() > numTicketMax) {
                numTicketMax = entity.getNumTicket();
            }
        }
        return numTicketMax;
    }
}
