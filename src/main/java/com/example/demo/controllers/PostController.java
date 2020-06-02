/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.Business.services.DemoService;
import com.example.demo.model.entities.dtos.Employee;
import com.example.demo.model.entities.dtos.ProductDto;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class PostController {
    
    @Autowired
    DemoService demoService;
    @RequestMapping(method = RequestMethod.POST,value = "/createProduct")    
    public ResponseEntity createProduct(@RequestBody ProductDto product) {
        //create product
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
   @RequestMapping(method = RequestMethod.PUT,value = "/editProduct/{name}")    
    public ResponseEntity updateProduct(@PathVariable("name") String name,@RequestBody ProductDto product) {
        //edit product
        product.setName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    //This method does not contain any Request Body. We can send request parameters and path variables.
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteProduct/{id}")    
    public ResponseEntity deleteProduct(@PathVariable("id") String id) {
        
        //delete product
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
    //validations
    @RequestMapping(method = RequestMethod.POST,value = "/createEmployee")    
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        
        //create employee
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
}
