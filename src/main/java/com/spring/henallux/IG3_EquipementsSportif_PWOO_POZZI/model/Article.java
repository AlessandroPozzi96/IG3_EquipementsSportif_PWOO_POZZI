package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Article implements Serializable {
    //Clé : code barre et valeur : nombre d'articles sélectionner
    private HashMap<Integer, Integer> achatsArticles = new HashMap<>();
    @NotNull
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private Integer nbArticles;
    private ArrayList<LignePanier> lignesPaniers = new ArrayList<>();
    private TypeArticle typeArticle;
    private TypeArticleDAO typeArticleDAO;
    private LignePanier lignePanier;

    @Autowired
    public Article(TypeArticleDAO typeArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
    }

    public Article() {
    }

    public HashMap<Integer, Integer> getAchatsArticles() {
        return achatsArticles;
    }

    public void setAchatsArticles(HashMap<Integer, Integer> achatsArticles) {
        this.achatsArticles = achatsArticles;
    }

    public Integer getNbArticlesPanier() {
        Integer nbArticlesTot = 0;
        for (Map.Entry<Integer, Integer> entry : achatsArticles.entrySet()) {
            nbArticlesTot += entry.getValue();
        }
        return nbArticlesTot;
    }

    public void addArticlesPanier(Integer codeBarre, Integer nbArticles) throws ModelException{
        if (nbArticles == null || nbArticles <= 0) {
            throw new ModelException("Article", "achatsArticles");
        }
        else
        {
            Integer nbArticlesTmp = achatsArticles.get(codeBarre);
            if (nbArticlesTmp != null) {
                nbArticlesTmp += nbArticles;
                achatsArticles.put(codeBarre, nbArticlesTmp);
                System.out.println("COMMANDE D'UN 2EME ARTICLE SIMILAIRE valeur : nbArticles " + nbArticles + " nbArticlesTmp : " + nbArticlesTmp);
            }
            else
            {
                achatsArticles.put(codeBarre, nbArticles);
                System.out.println("article ajouter : cb" + codeBarre + " nb : " + nbArticles);
            }
        }
    }

    public void removeArticlesPanier(Integer codeBarre) {
        achatsArticles.remove(codeBarre);
    }

    public Integer getNbArticles() {
        return nbArticles;
    }

    public void setNbArticles(Integer nbArticles) {
        this.nbArticles = nbArticles;
    }

    public ArrayList<LignePanier> getLignesPaniers() {
        if (achatsArticles == null) {
            System.out.println("Article : hashmap null !");
        }
        for (Map.Entry<Integer, Integer> entry : achatsArticles.entrySet()) {
            typeArticle = typeArticleDAO.findByCodeBarre(entry.getKey());
            lignePanier = new LignePanier(typeArticle.getCodeBarre(), typeArticle.getLibelle_fr(), entry.getValue(), entry.getValue() * typeArticle.getPrix(), typeArticle.getPrix());
            lignesPaniers.add(lignePanier);
        }
        return lignesPaniers;
    }

    public void setLignesPaniers(ArrayList<LignePanier> lignesPaniers) {
        this.lignesPaniers = lignesPaniers;
    }

    public Double getPrixTot() {
        Double prixTot = 0.0;
        for (LignePanier lignePanier : lignesPaniers) {
            prixTot += lignePanier.getPrix();
        }
        return prixTot;
    }

    public LignePanier getLignePanier() {
        return lignePanier;
    }

    public void setLignePanier(LignePanier lignePanier) {
        this.lignePanier = lignePanier;
    }
}
