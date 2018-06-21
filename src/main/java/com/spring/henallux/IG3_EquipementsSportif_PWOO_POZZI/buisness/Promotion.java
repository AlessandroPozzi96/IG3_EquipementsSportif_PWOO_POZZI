package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Promotion {

    public Promotion() {
    }

    //Règles de promotion :
    //5% de réduction si article en double
    //10% de réduction si acheté en triple
    //...
    //On fixe la limite à 25% si le même article est acheté plus de 5 fois
    public Double calculPromotion(Panier panier) {
        Double prixAvecPromo = 0.0;
        for (Map.Entry<Article, Integer> panierEntry : panier.getPanierHashMap().entrySet()) {
            switch (panierEntry.getValue()) {
                case 1 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey());
                    break;
                case 2 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * 0.95;
                    break;
                case 3 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * 0.9;
                    break;
                case 4 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * 0.85;
                    break;
                case 5 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * 0.8;
                    break;
                default: prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * 0.75;
            }
        }

        //Méthode pour arrondir un double a 2 décimales.
        prixAvecPromo = new BigDecimal(prixAvecPromo).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return prixAvecPromo;
    }
}
