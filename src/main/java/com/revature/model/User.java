package com.revature.model;

import java.io.Serializable;

public class User implements Serializable {

    private int user_ID;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean is_Active;
    private Integer role_ID;

    public User(){

    }

    public User(String username, String email, String password, String firstName, String lastName, Boolean is_Active, Integer role_ID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.is_Active = is_Active;
        this.role_ID = role_ID;
    }

    public User(int user_ID, String username, String email, String password, String firstName, String lastName, Boolean is_Active, Integer role_ID) {
        this.user_ID = user_ID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.is_Active = is_Active;
        this.role_ID = role_ID;
    }

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

    public Boolean getIs_Active() {
        return is_Active;
    }

    public void setIs_Active(Boolean is_Active) {
        this.is_Active = is_Active;
    }

    public Integer getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(Integer role_ID) {
        this.role_ID = role_ID;
    }
}
