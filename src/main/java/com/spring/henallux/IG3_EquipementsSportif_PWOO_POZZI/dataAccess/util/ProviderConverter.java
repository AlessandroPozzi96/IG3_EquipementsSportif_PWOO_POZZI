package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.User;
import org.springframework.stereotype.Component;

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
        userEntity.setCodePostale(user.getCodePostale());
        userEntity.setLocalite(user.getLocalite());
        userEntity.setMail(user.getMail());
        userEntity.setMale(user.getMale());
        userEntity.setNom(user.getNom());
        userEntity.setPrenom(user.getPrenom());
        userEntity.setNumTelephone(user.getNumTelephone());
        userEntity.setRue(user.getRue());
        GregorianCalendar calendar = user.getDateNaissance();
        java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
        userEntity.setDateNaissance(sqlDate);

        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setCodePostale(userEntity.getCodePostale());
        user.setLocalite(userEntity.getLocalite());
        user.setMail(userEntity.getMail());
        user.setNumTelephone(userEntity.getNumTelephone());
        user.setRue(userEntity.getRue());
        user.setMale(userEntity.getMale());
        //On convertit la date
        java.sql.Date sqlDate = userEntity.getDateNaissance();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(sqlDate);
        user.setDateNaissance(calendar);
        user.setConfirmPassWord(userEntity.getPassword());
        return user;
    }
}
