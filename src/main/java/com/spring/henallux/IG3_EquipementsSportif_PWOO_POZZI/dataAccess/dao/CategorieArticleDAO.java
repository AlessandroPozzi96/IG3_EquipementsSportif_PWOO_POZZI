package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.CategorieArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.CategorieArticleRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.CategorieArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieArticleDAO {
    private CategorieArticleRepository categorieArticleRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategorieArticleDAO(CategorieArticleRepository categorieArticleRepository, ProviderConverter providerConverter) {
        this.categorieArticleRepository = categorieArticleRepository;
        this.providerConverter = providerConverter;
    }

    public CategorieArticleEntity findById(Integer id) {
        return categorieArticleRepository.findByIdOrderByIdAsc(id);
    }

    public ArrayList<CategorieArticle> getAllCategories() {
        List<CategorieArticleEntity> categorieArticleEntities = categorieArticleRepository.findAll();
        ArrayList<CategorieArticle> categorieArticles = new ArrayList<>();
        for (CategorieArticleEntity entity : categorieArticleEntities) {
            CategorieArticle categorieArticle = providerConverter.categorieArticleEntityToCategorieArticleModel(entity);
            categorieArticles.add(categorieArticle);
        }
        return categorieArticles;
    }
}
