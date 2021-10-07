package com.example.demo.dto.request;

import java.util.Set;

public class SignUpForm {
    private String username;
    private String password;
    private String phoneNumber;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String username,  String password,String phoneNumber, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

