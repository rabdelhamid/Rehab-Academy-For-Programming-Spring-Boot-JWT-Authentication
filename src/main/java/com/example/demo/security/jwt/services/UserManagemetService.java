/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.services;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.security.jwt.daos.UsersRepository;
import com.example.demo.security.jwt.entities.Users;
import com.example.demo.security.jwt.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Transactional
public class UserManagemetService {
    
   @Autowired
   private UsersRepository userRepository;
    
   @Autowired
   private BCryptPasswordEncoder bcryptEncoder;
   
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    
    public void login(UserLoginDto userObj)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userObj.getUserName());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userObj.getPlainPassword(), userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);           
        }
    }
}
