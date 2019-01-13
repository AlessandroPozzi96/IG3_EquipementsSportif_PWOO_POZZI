package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Promotion {

    public Promotion() {
    }

    //Règles de promotion :
    //15% de réduction si article en double
    //20% de réduction si acheté en triple
    //...
    //On fixe la limite à 35% si le même article est commandé plus de 5 fois
    public Double calculPromotion(Panier panier) {
        Double prixAvecPromo = 0.0;
        for (Map.Entry<Article, Integer> panierEntry : panier.getPanierHashMap().entrySet()) {
            switch (panierEntry.getValue()) {
                case 1 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey());
                    break;
                case 2 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * Constants.PROMO2ARTICLES;
                    break;
                case 3 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * Constants.PROMO3ARTICLES;
                    break;
                case 4 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * Constants.PROMO4ARTICLES;
                    break;
                case 5 : prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * Constants.PROMO5ARTICLES;
                    break;
                default: prixAvecPromo += panier.getPrixArticle(panierEntry.getKey()) * Constants.PROMOSUPA5ARTICLES;
            }
        }

        //Méthode pour arrondir un double a 2 décimales.
        prixAvecPromo = new BigDecimal(prixAvecPromo).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return prixAvecPromo;
    }

    public Double calculPromotionParArticle(Article article, Integer quantite) {
        Double prixAvecPromo = 0.0;
        switch (quantite) {
            case 1 : prixAvecPromo += article.getPrixUnitaire();
                break;
            case 2 : prixAvecPromo += (article.getPrixUnitaire() * quantite) * Constants.PROMO2ARTICLES;
                break;
            case 3 : prixAvecPromo += (article.getPrixUnitaire() * quantite) * Constants.PROMO3ARTICLES;
                break;
            case 4 : prixAvecPromo += (article.getPrixUnitaire() * quantite) * Constants.PROMO4ARTICLES;
                break;
            case 5 : prixAvecPromo += (article.getPrixUnitaire() * quantite) * Constants.PROMO5ARTICLES;
                break;
            default: prixAvecPromo += (article.getPrixUnitaire() * quantite) * Constants.PROMOSUPA5ARTICLES;
        }
        prixAvecPromo = new BigDecimal(prixAvecPromo).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return prixAvecPromo;
    }
}
