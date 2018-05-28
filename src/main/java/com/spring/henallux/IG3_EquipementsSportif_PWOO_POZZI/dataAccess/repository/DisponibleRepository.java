package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponiblePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibleRepository extends JpaRepository<DisponibleEntity, DisponiblePK> {
}
