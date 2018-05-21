package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception.ModelException;

import javax.validation.constraints.Size;
import java.util.GregorianCalendar;

public class User {
    //12 var
    @Size(min = 3, max = 50)
    private String username;
    @Size(min = 6, max = 200)
    private String password;
    @Size(min = 6, max = 200)
    private String confirmPassWord;

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

    public String getConfirmPassWord() {
        return confirmPassWord;
    }

    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
    }
}
