/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.constants;

/**
 *
 * @author rehab.abd-elhamid
 */
public abstract class ConstantStrings {
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1000 * 60 * 60 * 10;//10 houres
    public static final String SIGNING_KEY = "secretkey";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization"; 
    
}
