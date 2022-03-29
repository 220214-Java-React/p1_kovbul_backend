package com.revature.model;

public enum ReimbursementStatuses {

    Pending("Pending"),
    Approved("Approved"),
    Denied("Denied");

    public final String value;

    ReimbursementStatuses(String value){
        this.value = value;
    }
}
