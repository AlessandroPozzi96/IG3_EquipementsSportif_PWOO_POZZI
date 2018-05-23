package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.CategorieArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieArticleRepository extends JpaRepository<CategorieArticleEntity, Integer> {
    CategorieArticleEntity findByIdOrderByIdAsc(Integer id);
}
