/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Component
public class DemoInterceptor implements HandlerInterceptor{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DemoInterceptor.class);

  @Override
   public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      LOGGER.info("Perform operations before sending the request to the controller");
      return true;//should return true to return the response to the client.

   }
   @Override
   public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, 
      ModelAndView modelAndView) throws Exception {
            LOGGER.info("Perform operations before sending the response to the client. ");
   }
   
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
      Object handler, Exception exception) throws Exception {
        LOGGER.info("Perform operations after completing the request and response.");
   }  
}
