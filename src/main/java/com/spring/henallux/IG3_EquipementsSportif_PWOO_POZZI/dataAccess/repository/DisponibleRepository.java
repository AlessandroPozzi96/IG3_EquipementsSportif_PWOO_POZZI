package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponiblePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisponibleRepository extends JpaRepository<DisponibleEntity, DisponiblePK> {
    @Query("select disponible from DisponibleEntity disponible where disponible.disponiblePK.codeBarre_fk = ?1")
    List<DisponibleEntity> findAllByCodeBarre(Integer codeBarre);
}
