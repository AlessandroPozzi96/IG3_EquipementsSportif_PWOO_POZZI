package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.CategorieArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.TypeArticleEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.CategorieArticle;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.TypeArticle;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class ProviderConverter {

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setAuthorities("ROLE_USER");
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        userEntity.setNom(user.getNom());
        userEntity.setPrenom(user.getPrenom());
        userEntity.setMail(user.getMail());
        userEntity.setLocalite(user.getLocalite());
        userEntity.setRue(user.getRue());
        userEntity.setCodePostal(user.getCodePostal());
        userEntity.setNumTelephone(user.getNumTelephone());
        java.sql.Date sqlDate = new java.sql.Date(user.getDateNaissance().getTime());
        userEntity.setDateNaissance(sqlDate);
        userEntity.setMale(user.getMale());

        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setConfirmPassword(userEntity.getPassword());
        user.setNom(userEntity.getNom());
        user.setPrenom(userEntity.getPrenom());
        user.setMail(userEntity.getMail());
        user.setLocalite(userEntity.getLocalite());
        user.setRue(userEntity.getRue());
        user.setCodePostal(userEntity.getCodePostal());
        user.setNumTelephone(userEntity.getNumTelephone());
        java.util.Date date = convertFromSQLDateToJAVADate(userEntity.getDateNaissance());
        user.setDateNaissance(date);
        user.setMale(userEntity.getMale());

        return user;
    }

    public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }

    public CategorieArticle categorieArticleEntityToCategorieArticleModel(CategorieArticleEntity categorieArticleEntity) {
        CategorieArticle categorieArticle = new CategorieArticle();

        categorieArticle.setId(categorieArticleEntity.getId());
        categorieArticle.setLibelle_fr(categorieArticleEntity.getLibelle_fr());
        categorieArticle.setLibelle_en(categorieArticleEntity.getLibelle_en());

        return categorieArticle;
    }

    public CategorieArticleEntity categorieArticleModelToCategorieArticleEntity(CategorieArticle categorieArticle) {
        CategorieArticleEntity categorieArticleEntity = new CategorieArticleEntity();

        categorieArticleEntity.setId(categorieArticle.getId());
        categorieArticleEntity.setLibelle_en(categorieArticle.getLibelle_en());
        categorieArticleEntity.setLibelle_fr(categorieArticle.getLibelle_fr());

        return categorieArticleEntity;
    }

    public TypeArticle typeArticleEntityToTypeArticleModel(TypeArticleEntity typeArticleEntity) {
        TypeArticle typeArticle = new TypeArticle();

        typeArticle.setCodeBarre(typeArticleEntity.getCodeBarre());
        typeArticle.setLibelle_en(typeArticleEntity.getLibelle_en());
        typeArticle.setLibelle_fr(typeArticleEntity.getLibelle_fr());
        typeArticle.setDescription_en(typeArticleEntity.getDescription_en());
        typeArticle.setDescription_fr(typeArticleEntity.getDescription_fr());
        typeArticle.setPrix(typeArticleEntity.getPrix());
        typeArticle.setId_categorie_fk(typeArticleEntity.getCategorieArticleEntity().getId());

        return typeArticle;
    }
}
