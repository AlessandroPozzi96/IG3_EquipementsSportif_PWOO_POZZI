package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PanierModelRepository extends JpaRepository<PanierEntity, String> {
}
