/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Business.services;

import com.example.demo.daos.GetRequestDao;
import com.example.demo.model.entities.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author user
 */
@Service
public class GetRequestService {
    @Autowired 
    GetRequestDao getRequestDao;
     public ProductDto SearchProducts(ProductDto searchDto) {
         
         return getRequestDao.SearchProducts(searchDto);
     }
}
