package com.revature.model;

public enum ReimbursementTypes {

    Lodging("Lodging"),
    Travel("Travel"),
    Food("Food"),
    Other("Other");

    public final String value;

    ReimbursementTypes(String value){
        this.value = value;
    }

}
