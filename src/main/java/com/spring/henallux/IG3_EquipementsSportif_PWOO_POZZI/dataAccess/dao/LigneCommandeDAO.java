package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.LigneCommandeEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.LigneCommandeRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.LigneCommande;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LigneCommandeDAO
{
    private LigneCommandeRepository ligneCommandeRepository;
    private ProviderConverter providerConverter;
    private SessionFactory sessionFactory;

    @Autowired
    public LigneCommandeDAO(LigneCommandeRepository ligneCommandeRepository, ProviderConverter providerConverter, SessionFactory sessionFactory) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.providerConverter = providerConverter;
        this.sessionFactory = sessionFactory;
    }

    public void saveLigneCommande(LigneCommande ligneCommande) {
        LigneCommandeEntity ligneCommandeEntity = providerConverter.ligneCommandeModelToLigneCommandeEntity(ligneCommande);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //ligneCommandeRepository.save(ligneCommandeEntity);
        session.save(ligneCommandeEntity);
        session.getTransaction().commit();
    }
}
