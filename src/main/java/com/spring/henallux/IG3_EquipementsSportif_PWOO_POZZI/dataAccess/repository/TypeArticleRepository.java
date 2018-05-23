package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TypeArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeArticleRepository extends JpaRepository<TypeArticleEntity, Integer> {
    @Query("select typearticle from TypeArticleEntity typearticle where typearticle.categorieArticleEntity.id like ?1")
    List<TypeArticleEntity> findByCategorieArticleEntityId(Integer id);
    TypeArticleEntity findByCodeBarre(Integer codeBarre);
}
