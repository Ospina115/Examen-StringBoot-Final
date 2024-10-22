package com.example.proyect.demo.domain.dto.auth;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable{

    private String username;
    private String password;
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

}