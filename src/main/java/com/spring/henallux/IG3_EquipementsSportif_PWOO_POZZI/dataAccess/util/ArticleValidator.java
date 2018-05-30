package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;


import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArticleValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Panier.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Panier panier = (Panier) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbArticles", "NotEmpty");
        if (panier.getNbArticles() < 1 || panier.getNbArticles() > Integer.MAX_VALUE) {
            errors.rejectValue("nbArticles", "Size.formPanier.nbArticles");
        }
    }
}
