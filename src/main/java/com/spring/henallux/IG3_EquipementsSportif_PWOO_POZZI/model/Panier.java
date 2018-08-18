package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import com.google.gson.Gson;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;
import org.springframework.boot.json.GsonJsonParser;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
    //Clé : article et valeur : quantite
    private HashMap<Article, Integer> panierHashMap;
    private String taille = "";
    private String couleur = "";
    private Gson gson = new Gson();
    private Boolean payementValide;

    public Panier() {
        panierHashMap = new HashMap<>();
        payementValide = false;
    }

    public HashMap<Article, Integer> getPanierHashMap() {
        return panierHashMap;
    }

    public void setPanierHashMap(HashMap<Article, Integer> panierHashMap) {
        this.panierHashMap = panierHashMap;
    }

    public Integer getNbArticlesPanier() {
        Integer nbArticlesTot = 0;
        for (Map.Entry<Article, Integer> panierEntry : panierHashMap.entrySet()) {
            nbArticlesTot += panierEntry.getValue();
        }
        return nbArticlesTot;
    }

    public Double getPrixArticle(Article article) {
        Integer quantite = panierHashMap.get(article);
        if (quantite != null && quantite > 0) {
            Double prix = quantite * article.getPrixUnitaire();
            prix = new BigDecimal(prix).setScale(2, RoundingMode.HALF_UP).doubleValue();
            return prix;
        }
        else
            return 0.0;
    }

    public Double getPrixPanier() {
        Double prixTot = 0.0;
        for (Map.Entry<Article, Integer> panierEntry : panierHashMap.entrySet()) {
            prixTot += (getPrixArticle(panierEntry.getKey()));
        }
        prixTot = new BigDecimal(prixTot).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return prixTot;
    }

    public void addAchatPanier(Article article, Integer quantite) {
        panierHashMap.put(article, quantite);
        setTaille("");
        setCouleur("");
    }

    public void modifierQuantitePanier(Article article, int quantite) {
        if (quantite > 0) {
            Integer quantiteTmp = panierHashMap.get(article);
            if (quantiteTmp != null) {
                panierHashMap.put(article, quantite);
                System.out.println("CLASSE PANIER : QUANTITE MODIFIER ! (" + quantite + ")");
            }
            else
            {
                System.out.println("CLASSE PANIER : ERREUR ARTICLE INTROUVABLE !");
            }
        }
    }

    public void removeArticlesPanier(Article article) {
        System.out.println("CLASSE PANIER : ARTICLE EN COURS DE SUPPRESSION");
        panierHashMap.remove(article);
        Integer qte = panierHashMap.get(article);
        if (qte != null) {
            System.out.println("CLASSE PANIER : ERREUR ARTICLE NON SUPPRIME !");
        }
        else
        {
            System.out.println("CLASSE PANIER : SUCCES !");
        }
    }

    public void viderPanier() {
        panierHashMap.clear();
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

    public String articleToJson(Article article) {
        String json = gson.toJson(article);
        String jsonEncode = "";
        try {
            jsonEncode = URLEncoder.encode(json, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            jsonEncode = json;
            System.out.println("ERREUR ENCODAGE URL JSON");
        }

        return jsonEncode;
    }
    //Pourquoi encoder en Json puis encore l'encoder en UTF-8 ?
    //Parce que sinon uniquement au format Json le serveur TomCat renvoyait une erreur à cause des caractères spéciaux !

    public Article jsonToArticle(String json) {
        String jsonDecode = "";
        try {
            jsonDecode = URLDecoder.decode(json, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            jsonDecode = json;
            System.out.println("ERREUR DECODAGE URL JSON");
        }
        Article article = gson.fromJson(jsonDecode, Article.class);
        return article;
    }

    @Override
    public String toString() {
        String description = "";
        for (Map.Entry<Article, Integer> panierEntry : panierHashMap.entrySet()) {
            description += panierEntry.getKey().toString() + " Quantité -> " + panierEntry.getValue();
        }
        return description;
    }

    public Boolean getPayementValide() {
        return payementValide;
    }

    public void setPayementValide(Boolean payementValide) {
        this.payementValide = payementValide;
    }
}
