package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.*;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
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
        categorieArticle.setUrl_image(categorieArticleEntity.getUrl_image());

        return categorieArticle;
    }

    public CategorieArticleEntity categorieArticleModelToCategorieArticleEntity(CategorieArticle categorieArticle) {
        CategorieArticleEntity categorieArticleEntity = new CategorieArticleEntity();

        categorieArticleEntity.setId(categorieArticle.getId());
        categorieArticleEntity.setUrl_image(categorieArticle.getUrl_image());

        return categorieArticleEntity;
    }

    public TypeArticle typeArticleEntityToTypeArticleModel(TypeArticleEntity typeArticleEntity) {
        TypeArticle typeArticle = new TypeArticle();

        typeArticle.setCodeBarre(typeArticleEntity.getCodeBarre());
        typeArticle.setPrix(typeArticleEntity.getPrix());
        typeArticle.setId_categorie_fk(typeArticleEntity.getCategorieArticleEntity().getId());

        return typeArticle;
    }

    public Image imageEntityToImageModel(ImageEntity imageEntity) {
        Image image = new Image();

        image.setUrl(imageEntity.getUrl());

        return image;
    }

    public Taille tailleEntityToTailleModel(TailleEntity tailleEntity) {
        Taille taille = new Taille();
        taille.setTailleArticle(tailleEntity.getTailleArticle());

        return taille;
    }

    public TailleEntity tailleModelToTailleEntity(Taille taille) {
        TailleEntity tailleEntity = new TailleEntity();

        tailleEntity.setTailleArticle(taille.getTailleArticle());

        return tailleEntity;
    }

    public Couleur couleurEntityToCouleurModel(CouleurEntity couleurEntity) {
        Couleur couleur = new Couleur();

        couleur.setId(couleurEntity.getId());

        return couleur;
    }

    public CouleurEntity couleurModelToCouleurEntity(Couleur couleur) {
        CouleurEntity couleurEntity = new CouleurEntity();

        couleurEntity.setId(couleur.getId());

        return couleurEntity;
    }

    public Disponible disponibleEntityToDisponibleModel(DisponibleEntity disponibleEntity) {
        Disponible disponible = new Disponible();
        disponible.setCodeBarre_fk(disponibleEntity.getDisponiblePK().getCodeBarre_fk());
        disponible.setTaille_fk(disponibleEntity.getDisponiblePK().getTaille_fk());

        return disponible;
    }

    public DisponibleEnCouleur disponibleEnCouleurEntityToDisponibleEnCouleurModel(DisponibleEnCouleurEntity disponibleEnCouleurEntity) {
        DisponibleEnCouleur disponibleEnCouleur = new DisponibleEnCouleur();
        disponibleEnCouleur.setCodeBarre_fk(disponibleEnCouleurEntity.getDisponibleEnCouleurPK().getCodeBarre_fk());
        disponibleEnCouleur.setCouleur_fk(disponibleEnCouleurEntity.getDisponibleEnCouleurPK().getCouleur_fk());

        return disponibleEnCouleur;
    }

    public TranslationCategorie translationCategorieEntityToTranslationCategorieModel(TranslationCategorieEntity translationCategorieEntity) {
        TranslationCategorie translationCategorie = new TranslationCategorie();

        translationCategorie.setIdCategorie_FK(translationCategorieEntity.getTranslationCategoriePK().getIdCategorie_FK());
        translationCategorie.setLangageID_FK(translationCategorieEntity.getTranslationCategoriePK().getLangageID_FK());
        translationCategorie.setLibelle(translationCategorieEntity.getLibelle());

        return translationCategorie;
    }

    public TranslationArticle translationArticleEntityToTranslationArticleModel(TranslationArticleEntity translationArticleEntity) {
        TranslationArticle translationArticle = new TranslationArticle();

        translationArticle.setCodeBarre_FK(translationArticleEntity.getTranslationArticlePK().getCodeBarre_FK());
        translationArticle.setLangageID_FK(translationArticleEntity.getTranslationArticlePK().getLangageID_FK());
        translationArticle.setDescription(translationArticleEntity.getDescription());
        translationArticle.setLibelle(translationArticleEntity.getLibelle());

        return translationArticle;
    }

    public PanierEntity panierModelToPanierEntity(PanierModel panierModel, UserEntity userEntity) {
        PanierEntity panierEntity = new PanierEntity();
        panierEntity.setUserEntity(userEntity);
        panierEntity.setNumTicket(panierModel.getNumTicket());
        Timestamp timestamp = new Timestamp(panierModel.getDate().getTime());
        panierEntity.setDate(timestamp);

        return panierEntity;
    }

    public TranslationCouleur translationCouleurEntityToTranslationCouleurModel(TranslationCouleurEntity translationCouleurEntity) {
        TranslationCouleur translationCouleur = new TranslationCouleur();
        translationCouleur.setIdCouleur_FK(translationCouleurEntity.getTranslationCouleurPK().getIdCouleur_FK());
        translationCouleur.setLangageID_FK(translationCouleurEntity.getTranslationCouleurPK().getLangageID_FK());
        translationCouleur.setLibelle(translationCouleurEntity.getLibelle());

        return translationCouleur;
    }
}
