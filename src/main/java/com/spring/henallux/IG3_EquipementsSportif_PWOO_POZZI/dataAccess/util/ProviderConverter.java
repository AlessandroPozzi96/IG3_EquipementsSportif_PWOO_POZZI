package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.*;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

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

    public java.util.Date convertFromSQLDateToJAVADate(
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

    public CommandeEntity commandeModelToCommandeEntity(Commande commande, UserEntity userEntity) {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setUserEntity(userEntity);
        commandeEntity.setNumTicket(commande.getNumTicket());
        Timestamp timestamp = new Timestamp(commande.getDate().getTime());
        commandeEntity.setDate(timestamp);

        return commandeEntity;
    }

    public Commande commandeEntityToCommandeModel(CommandeEntity commandeEntity) {
        Commande commande = new Commande();
        commande.setUsername_fk(commandeEntity.getUserEntity().getUsername());
        commande.setNumTicket(commandeEntity.getNumTicket());
        commande.setDate(commandeEntity.getDate());

        return commande;
    }

    public TranslationCouleur translationCouleurEntityToTranslationCouleurModel(TranslationCouleurEntity translationCouleurEntity) {
        TranslationCouleur translationCouleur = new TranslationCouleur();
        translationCouleur.setIdCouleur_FK(translationCouleurEntity.getTranslationCouleurPK().getIdCouleur_FK());
        translationCouleur.setLangageID_FK(translationCouleurEntity.getTranslationCouleurPK().getLangageID_FK());
        translationCouleur.setLibelle(translationCouleurEntity.getLibelle());

        return translationCouleur;
    }

    public LigneCommandeEntity ligneCommandeModelToLigneCommandeEntity(LigneCommande ligneCommande) {
        LigneCommandeEntity ligneCommandeEntity = new LigneCommandeEntity();
        ligneCommandeEntity.setPrixReel(ligneCommande.getPrixReel());
        ligneCommandeEntity.setQuantite(ligneCommande.getQuantite());
        ligneCommandeEntity.setTaille_fk(ligneCommande.getTaille_fk());
        ligneCommandeEntity.setCouleur_fk(ligneCommande.getCouleur_fk());

        LigneCommandePK ligneCommandePK = new LigneCommandePK();
        ligneCommandePK.setCodeBarre_fk(ligneCommande.getCodeBarre_fk());
        ligneCommandePK.setNumTicket_fk(ligneCommande.getNumTicket_fk());
        ligneCommandeEntity.setLigneCommandePK(ligneCommandePK);

        return ligneCommandeEntity;
    }
}
