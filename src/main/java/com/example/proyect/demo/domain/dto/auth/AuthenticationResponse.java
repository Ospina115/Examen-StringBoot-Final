package com.example.proyect.demo.domain.dto.auth;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
