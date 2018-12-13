package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEnCouleurEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibleEnCouleurRepository extends JpaRepository<DisponibleEnCouleurEntity, Integer> {
    List<DisponibleEnCouleurEntity> findAllByTypeArticleEntity_CodeBarre(Integer codeBarre);
}
