/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.daos;


import com.example.demo.security.jwt.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rehab.abd-elhamid
 */
public interface UsersRepository extends JpaRepository<Users, String>{
   
   
    @Query("SELECT u FROM Users u WHERE UPPER(TRIM(u.userName))=UPPER(TRIM(:username))")
    public Users findByUsername(@Param("username")String username);
   
}
