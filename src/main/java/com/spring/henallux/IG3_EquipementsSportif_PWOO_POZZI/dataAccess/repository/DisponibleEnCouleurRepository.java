package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEnCouleurEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.DisponibleEnCouleurPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibleEnCouleurRepository extends JpaRepository<DisponibleEnCouleurEntity, DisponibleEnCouleurPK> {
    @Query("select disponibleEnCouleur from DisponibleEnCouleurEntity disponibleEnCouleur where disponibleEnCouleur.disponibleEnCouleurPK.codeBarre_fk = ?1")
    List<DisponibleEnCouleurEntity> findAllByCodeBarre(Integer codeBarre);
}
