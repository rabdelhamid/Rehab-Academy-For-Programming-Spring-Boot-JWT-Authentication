/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//https://programmer.group/how-do-spring-boot-2.x-add-interceptors.html
package com.example.demo.Configuration;

import com.example.demo.Interceptors.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 *
 * @author user
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Autowired
    private DemoInterceptor demoInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(demoInterceptor);
    }
}
