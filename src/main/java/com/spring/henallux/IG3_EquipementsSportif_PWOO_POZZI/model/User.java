package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import javax.validation.constraints.Size;

public class User {
    @Size(min = 3, max = 20)
    private String username;
    @Size(min = 6, max = 14)
    private String password;

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
}
