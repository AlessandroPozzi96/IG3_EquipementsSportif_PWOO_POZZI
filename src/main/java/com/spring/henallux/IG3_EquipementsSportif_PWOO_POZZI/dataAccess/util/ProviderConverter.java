package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
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
}
