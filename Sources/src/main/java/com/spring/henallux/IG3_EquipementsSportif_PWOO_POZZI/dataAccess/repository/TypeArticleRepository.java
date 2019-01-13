package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TypeArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeArticleRepository extends JpaRepository<TypeArticleEntity, Integer> {
    List<TypeArticleEntity> findByCategorieArticleEntity_Id(Integer id);
    TypeArticleEntity findByCodeBarre(Integer codeBarre);
}
