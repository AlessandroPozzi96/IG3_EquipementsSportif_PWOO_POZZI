package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.LigneCommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommandeEntity, Integer> {
}
