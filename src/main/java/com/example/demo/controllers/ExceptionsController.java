/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.model.entities.dtos.ProductDto;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class ExceptionsController {
     
   
    @RequestMapping(method = RequestMethod.GET,value = "/userExceptionHandling")    
    public String userExceptionHandling() throws NoDataFoundException {
        throw new NoDataFoundException("No Data Found Exception");
    }
    //EXCEPTION WITH PARAMTER
    @RequestMapping(method = RequestMethod.GET,value = "/userExceptionHandling/withParam")    
    public String userExceptionWithParamHandling() throws NoDataFoundException {
        throw new BusinessException("Business Exception With Parameter Occured", new String[]{"parameter 1","parameter 2"});
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/systemExceptionHandling")    
    public String systemExceptionHandling(@RequestParam("code")String code) {
         return "Hello get request :" + code;
    }
}
