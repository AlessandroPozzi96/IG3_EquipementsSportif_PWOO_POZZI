package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;


import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.TypeArticleDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArticleValidator implements Validator {
    private TypeArticleDAO typeArticleDAO;

    @Autowired
    public ArticleValidator(TypeArticleDAO typeArticleDAO) {
        this.typeArticleDAO = typeArticleDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Article.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Article articles = (Article) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbArticles", "NotEmpty");
        if (articles.getNbArticles() < 0 || articles.getNbArticles() > Integer.MAX_VALUE) {
            errors.rejectValue("nbArticles", "Size.formCommande.nbArticles");
        }
    }
}
