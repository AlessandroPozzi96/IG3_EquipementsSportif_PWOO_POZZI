package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.exception;

public class ModelException extends Exception {
    private String model;
    private String variable;

    public ModelException(String model, String variable) {
        this.model = model;
        this.variable = variable;
    }

    @Override
    public String getMessage() {
        return "Une exception a été levée en voulant attribuer la variable : " + this.variable + " au model : " + this.model;
    }
}
