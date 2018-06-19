package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;

import java.util.Map;

public class Promotion {

    public Promotion() {
    }

    //Règles de promotion :
    //20% de réduction si article en double
    //30% de réduction si acheté en triple
    //...
    //On fixe la limite à 50% si le même article est acheté plus de 5 fois
    public Double calculPromotion(Panier panier) {
        Double prixAvecPromo = 0.0;
        for (Map.Entry<Article, Integer> panierEntry : panier.getPanierHashMap().entrySet()) {
            switch (panierEntry.getValue()) {
                case 1 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey());
                break;
                case 2 : prixAvecPromo += 2 * panier.getPrixArticle(panierEntry.getKey()) * 0.8;
                break;
                case 3 : prixAvecPromo += 3 * panier.getPrixArticle(panierEntry.getKey()) * 0.7;
                break;
                case 4 : prixAvecPromo += 4 * panier.getPrixArticle(panierEntry.getKey()) * 0.6;
                break;
                case 5 : prixAvecPromo += 5 * panier.getPrixArticle(panierEntry.getKey()) * 0.5;
                break;
                default: prixAvecPromo += panierEntry.getValue() * panier.getPrixArticle(panierEntry.getKey()) * 0.5;
            }
        }
        return prixAvecPromo;
    }
}
