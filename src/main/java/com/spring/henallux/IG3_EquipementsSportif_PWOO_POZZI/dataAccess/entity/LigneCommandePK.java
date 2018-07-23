package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LigneCommandePK implements Serializable {
    @Column(name = "CODEBARRE_FK")
    private Integer codeBarre_fk;
    @Column(name = "NUMTICKET_FK")
    private Integer numTicket_fk;

    public LigneCommandePK() {
    }

    public Integer getCodeBarre_fk() {
        return codeBarre_fk;
    }

    public void setCodeBarre_fk(Integer codeBarre_fk) {
        this.codeBarre_fk = codeBarre_fk;
    }

    public Integer getNumTicket_fk() {
        return numTicket_fk;
    }

    public void setNumTicket_fk(Integer numTicket_fk) {
        this.numTicket_fk = numTicket_fk;
    }
}
