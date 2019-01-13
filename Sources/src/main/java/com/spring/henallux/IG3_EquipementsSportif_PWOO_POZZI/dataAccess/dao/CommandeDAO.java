package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.CommandeEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.CommandeRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Commande;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeDAO {
    private CommandeRepository commandeRepository;
    private ProviderConverter providerConverter;
    private SessionFactory sessionFactory;

    @Autowired
    public CommandeDAO(CommandeRepository commandeRepository, ProviderConverter providerConverter, SessionFactory sessionFactory) {
        this.commandeRepository = commandeRepository;
        this.providerConverter = providerConverter;
        this.sessionFactory = sessionFactory;
    }

    public void saveCommande(Commande commande, UserEntity userEntity) {
        CommandeEntity commandeEntity = providerConverter.commandeModelToCommandeEntity(commande, userEntity);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(commandeEntity);
        //commandeRepository.save(commandeEntity);
        session.getTransaction().commit();
    }

    public Integer findLastNumTicket(String username) {
        //Pas réussi à faire un top 1 via Hibernate donc le max est recherché manuellement
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
