package com.revature.model;


// enum, enumeration is a list of potential values; cannot be changed

public enum UserRoles {

    Admin("Admin"),
    FinanceManager("Finance Manager"),
    Employee("Employee");


    public final String value;

    UserRoles(String value){
        this.value = value;



    }

}
