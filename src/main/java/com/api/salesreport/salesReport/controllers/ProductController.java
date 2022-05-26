package com.api.salesreport.salesReport.controllers;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Products")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Product> find(@PathVariable Integer id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
