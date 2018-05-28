package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Article implements Serializable {
    //Clé : code barre et valeur : nombre d'articles sélectionner
    private HashMap<Integer, Integer> achatsArticles;
    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private Integer nbArticles = 0;
    private String taille = "";
    private String couleur = "";

    public Article() {
        achatsArticles = new HashMap<>();
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
                achatsArticles.put(codeBarre, nbArticles);
                System.out.println("MAJ QUANTITE : Article similaire ajoute au panier : nbArticles " + nbArticles + " nbArticlesTmp : " + nbArticlesTmp);
            }
            else
            {
                achatsArticles.put(codeBarre, nbArticles);
                System.out.println("NOUVEAU : article ajouter : cb" + codeBarre + " nb : " + nbArticles);
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

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
