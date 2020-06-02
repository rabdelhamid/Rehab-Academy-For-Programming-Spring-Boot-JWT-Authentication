/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

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
public class DemoController {
     //DEFAULT SECURITY
    //https://spring.io/guides/gs/securing-web/
    @RequestMapping(method = RequestMethod.GET,value = "/getproduct")    
    public ProductDto getProduct() {
        return new ProductDto("1", "iPhone", 999.99f);
    }
    //path variable
    @RequestMapping(value = "/getProductDetails/{productCode}", method = RequestMethod.GET)
    public String getProductDetails(@PathVariable("productCode") String productCode) {
          return "Hello get request :" + productCode;
    }
    //RequestParam
    @RequestMapping(value = "/getProductByParam", method = RequestMethod.GET)
    public String getProductPrice(@RequestParam("code")String productCode) {
          return "Hello get request :" + productCode;
    }
    //RequestParam notrequired
    @RequestMapping(value = "/getProductNotRequired", method = RequestMethod.GET)
    public String getProductInfoNotRequired(@RequestParam(name="code", required = false) String productCode) {
          if(productCode!=null)
                return "Hello get request :" + productCode;
          else
              return "Hello get request :request param is not required" ;
    }
    
    //RequestParam optional
    @RequestMapping(value = "/getProductOptional", method = RequestMethod.GET)
    public String getProductInfoOptional(@RequestParam("code") Optional<String> productCode) {
          if (productCode.isPresent()) 
                return "Hello get request :" + productCode;
          else
              return "Hello get request :request param is optional" ;
    }
    
    
}
