package com.revature.model;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

public class User implements Serializable {

    private int user_ID;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRoles userRoles;


    // empty user constructor

    public User(){

    }

    // constructor

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int user_id, String username, String email, String password, String first_name, String last_name, UserRoles userRoles) {
        this.user_ID = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = first_name;
        this.lastName = last_name;
        this.userRoles = userRoles;
    }

    public User(String username, String email, String password, String firstName, String lastName, UserRoles userRoles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRoles = userRoles;
    }


    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }



//    public UserRoles getRole_ID() {
//        return role_ID;
//    }
//
//    public void setRole_ID(UserRoles role_ID) {
//        this.role_ID = role_ID;
//    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }


}
