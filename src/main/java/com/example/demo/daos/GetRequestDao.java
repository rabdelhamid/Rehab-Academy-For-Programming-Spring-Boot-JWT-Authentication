/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.daos;

import com.example.demo.model.entities.dtos.ProductDto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class GetRequestDao {
    public ProductDto SearchProducts(ProductDto searchDto) {
        /** to do search in database**/
        if(searchDto.getCode()!=null) {            
        }
        if(searchDto.getName()!=null){            
        }
        if(searchDto.getPrice()!=0.0){            
        }
       return searchDto;
     }
    
}
