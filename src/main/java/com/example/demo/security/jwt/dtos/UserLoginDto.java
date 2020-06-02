/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.dtos;

/**
 *
 * @author user
 */
public class UserLoginDto {
    private String userName;
    private String plainPassword;

    public UserLoginDto(String userName, String plainPassword) {
        this.userName = userName;
        this.plainPassword = plainPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }
    
}
