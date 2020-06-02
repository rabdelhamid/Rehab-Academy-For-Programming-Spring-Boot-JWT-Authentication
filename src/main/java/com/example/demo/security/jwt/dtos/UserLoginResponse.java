package com.example.demo.security.jwt.dtos;

public class UserLoginResponse {

	private String token;
	private String fullName;

    public UserLoginResponse(String token) {
        this.token = token;
    }

    public UserLoginResponse(String token, String fullName) {
        this.token = token;
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
      
	
}
