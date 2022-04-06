package com.revature.model;


// enum for reimbursement types

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
