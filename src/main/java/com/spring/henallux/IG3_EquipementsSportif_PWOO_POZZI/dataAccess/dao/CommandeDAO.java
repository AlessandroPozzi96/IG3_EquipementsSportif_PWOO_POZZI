package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.CommandeEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.CommandeRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeDAO {
    private CommandeRepository commandeRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CommandeDAO(CommandeRepository commandeRepository, ProviderConverter providerConverter) {
        this.commandeRepository = commandeRepository;
        this.providerConverter = providerConverter;
    }

    public void saveCommande(Commande commande, UserEntity userEntity) {
        CommandeEntity commandeEntity = providerConverter.commandeModelToCommandeEntity(commande, userEntity);
        commandeRepository.save(commandeEntity);
    }

    public Integer findLastNumTicket(String username) {
        List<CommandeEntity> panierEntities = commandeRepository.findAllByUserEntityUsername(username);
        Integer numTicketMax = 0;
        for (CommandeEntity entity : panierEntities) {
            if (entity.getNumTicket() > numTicketMax) {
                numTicketMax = entity.getNumTicket();
            }
        }
        return numTicketMax;
    }
}
