/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security.jwt.utils;

import com.example.demo.model.entities.dtos.exceptions.ErrorDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rehab.abd-elhamid
 */
public final class FilterExceptionsUtil {
    
    public static  HttpServletResponse constructResponse(HttpServletResponse response,int httpStatus,String msg) throws JsonProcessingException, IOException {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), msg,msg);
        response.setStatus(httpStatus);
        response.getWriter().write(convertObjectToJson(errorDetails));
        return response;
                            
    } 
    public static  String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
