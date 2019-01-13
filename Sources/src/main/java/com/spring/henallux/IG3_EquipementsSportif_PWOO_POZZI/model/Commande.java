package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.util.Date;

public class Commande {
    @NotNull
    @Min(1)
    @Max(999999999)
    private Integer numTicket;
    @NotNull
    @Basic
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Past
    private java.util.Date date;
    @NotNull
    @Size(max = 50, min = 3)
    private String username_fk;

    public Commande() {
    }

    public Integer getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(Integer numTicket) {
        this.numTicket = numTicket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername_fk() {
        return username_fk;
    }

    public void setUsername_fk(String username_fk) {
        this.username_fk = username_fk;
    }
}
