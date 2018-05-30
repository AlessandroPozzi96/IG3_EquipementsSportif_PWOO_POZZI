package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import org.hibernate.annotations.SQLInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class User {
    @NotNull
    @Size(min = 3, max = 50)
    private String username;
    @NotNull
    @Size(min = 6, max = 32)
    private String password;
    @NotNull
    @Size(min = 6, max = 32)
    private String confirmPassword;
    @NotNull
    @Size(min = 3, max = 45)
    private String nom;
    @NotNull
    @Size(min = 3, max = 45)
    private String prenom;
    @NotNull
    @Size(min = 6, max = 320)
    private String mail;
    @NotNull
    @Size(min = 3, max = 45)
    private String localite;
    @NotNull
    @Size(min = 3, max = 45)
    private String rue;
    @NotNull
    @Max(Integer.MAX_VALUE)
    private Integer codePostal;
    @Max(Integer.MAX_VALUE)
    private Integer numTelephone;
    @NotNull
    @Basic
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Past
    private java.util.Date dateNaissance;
    @NotNull
    private Boolean isMale;

    public User() {
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public Integer getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(Integer numTelephone) {
        this.numTelephone = numTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }
}
