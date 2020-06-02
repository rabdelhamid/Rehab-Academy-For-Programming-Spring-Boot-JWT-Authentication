/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.controllers.unsecure;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.security.jwt.entities.Users;
import com.example.demo.security.jwt.dtos.UserLoginDto;
import com.example.demo.security.jwt.dtos.UserLoginResponse;
import com.example.demo.security.jwt.services.UserManagemetService;
import com.example.demo.security.jwt.utils.JwtTokenUtil;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController
public class LoginController {
  
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

   
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)    
    public ResponseEntity  login(@RequestBody UserLoginDto userObj)  {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userObj.getUserName(),
                        userObj.getPlainPassword()
                )
        );
       
        UserDetails userDetails = userDetailsService.loadUserByUsername(userObj.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new UserLoginResponse(token));
       
    }



}
