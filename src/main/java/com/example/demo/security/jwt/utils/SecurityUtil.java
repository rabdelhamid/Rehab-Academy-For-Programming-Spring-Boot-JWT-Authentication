/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.utils;



import com.example.demo.exceptions.BusinessException;
import com.example.demo.security.jwt.entities.CustomUser;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 *
 * @author rehab.abd-elhamid
 */
@Component
public class SecurityUtil implements Serializable {

    @Autowired
    private UserDetailsService userDetailsService;

    public void setAuthentication(String username) {
        CustomUser customUser = (CustomUser) this.userDetailsService.loadUserByUsername(username);
        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    customUser, null, customUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
       

    }
//
    public Optional<CustomUser> getAuthentication() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {

            Object principal = auth.getPrincipal();

            if (principal instanceof CustomUser) // User is your user type that implements UserDetails
            {
                return Optional.of((CustomUser) principal);
            }
        }

       return Optional.empty();
    }
    public CustomUser findAuthunticatedUser() {


        Optional<CustomUser> currentCustomUser = getAuthentication();
        if (!currentCustomUser.isPresent()) {

            throw new BusinessException("NOT_AUTHENTICATED_USER");

        }
        CustomUser customUser = currentCustomUser.get();

        return customUser;


    }
}
