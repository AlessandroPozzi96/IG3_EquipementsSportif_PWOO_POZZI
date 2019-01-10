package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PromotionTest {

    private Promotion promotion;
    private Panier panier;
    private Article articleBidon1;
    private Article articleBidon2;
    private Article articleBidon3;

    @Before
    public void setUp() throws Exception {
        promotion = new Promotion();
        panier = new Panier();
        articleBidon1 = new Article("articleBidon1", 7878, 15.5, "L", "Rouge");
        articleBidon2 = new Article("ArticleBidon2", 4565, 45.3, "", "");
        articleBidon3 = new Article("articleBidon3", 1232, 70.00, "S", "Bleu");
        panier.addAchatPanier(articleBidon1, 5); //54.25
        panier.addAchatPanier(articleBidon2, 2); //77.01
        panier.addAchatPanier(articleBidon3, 3); //168
        //Total en théorie = 229.26
    }

    @Test
    public void calculPromotion() {
        Assert.assertEquals(299.26, promotion.calculPromotion(panier), 0.01);
    }

    @Test
    public void calculPromotionArticle1() {
        Assert.assertEquals(54.25, promotion.calculPromotionParArticle(articleBidon1,5), 0.01);
    }

    @Test
    public void calculPromotionArticle2() {
        Assert.assertEquals(77.01, promotion.calculPromotionParArticle(articleBidon2,2), 0.01);
    }

    @Test
    public void calculPromotionArticle3() {
        Assert.assertEquals(168, promotion.calculPromotionParArticle(articleBidon3,3), 0.01);
    }
}