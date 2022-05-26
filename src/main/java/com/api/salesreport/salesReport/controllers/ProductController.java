package com.api.salesreport.salesReport.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

    
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    
    @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
