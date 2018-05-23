package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TypeArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.CategorieArticleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.TypeArticleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeArticleDAO {
    private TypeArticleRepository typeArticleRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TypeArticleDAO(TypeArticleRepository typeArticleRepository, ProviderConverter providerConverter) {
        this.typeArticleRepository = typeArticleRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<TypeArticle> findByCategorieArticleEntityId(Integer id) {
        List<TypeArticleEntity> typeArticleEntities = typeArticleRepository.findByCategorieArticleEntityId(id);
        ArrayList<TypeArticle> typeArticles = new ArrayList<>();
        for (TypeArticleEntity entity : typeArticleEntities) {
            TypeArticle typeArticle = providerConverter.typeArticleEntityToTypeArticleModel(entity);
            typeArticles.add(typeArticle);
        }
        return typeArticles;
    }

    public ArrayList<TypeArticle> getAllTypesArticles() {
        List<TypeArticleEntity> typeArticleEntities = typeArticleRepository.findAll();
        ArrayList<TypeArticle> typeArticles = new ArrayList<>();
        for (TypeArticleEntity entity : typeArticleEntities) {
            TypeArticle typeArticle = providerConverter.typeArticleEntityToTypeArticleModel(entity);
            typeArticles.add(typeArticle);
        }
        return typeArticles;
    }

    public TypeArticle findByCodeBarre(Integer codeBarre) {
        return providerConverter.typeArticleEntityToTypeArticleModel(typeArticleRepository.findByCodeBarre(codeBarre));
    }
}
