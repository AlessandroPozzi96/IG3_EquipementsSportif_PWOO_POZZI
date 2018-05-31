package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PANIER")
public class PanierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NUMTICKET")
    private Integer numTicket;

    @Column(name = "DATE")
    private java.sql.Date date;

    @JoinColumn(name = "USERNAME_FK", referencedColumnName = "USERNAME")
    @ManyToOne
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
