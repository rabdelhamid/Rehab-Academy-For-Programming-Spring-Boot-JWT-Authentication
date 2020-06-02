/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.Business.services.GetRequestService;
import com.example.demo.model.entities.dtos.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GetRequestJsonParController {
    
    @Autowired
    GetRequestService getRequestService;
    //Using RequestParam
    @RequestMapping(method = RequestMethod.GET,value = "/searchProducts")    
    public ProductDto SearchProducts(@RequestParam("search") String searchDto) {
        ProductDto productDto=new ProductDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productDto = objectMapper.readValue(searchDto, ProductDto.class);
        } catch (IOException ex) {
            /** do any staff here **/
        }
        return getRequestService.SearchProducts(productDto);
    }
    
    
    //https://onlinejsontools.com/url-encode-json
    @RequestMapping(method = RequestMethod.GET,value = "/convertJsonToString")    
    public String convertJsonToString()
    {
        String jsonString="";
        ProductDto productDto=new ProductDto("1", "iPhone", 999.99f);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(productDto);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(GetRequestJsonParController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonString;
     
    }
}
