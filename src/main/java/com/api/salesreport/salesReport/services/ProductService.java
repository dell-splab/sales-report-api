package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
    }
    
    public List<Product> findAll() {
		return productRepository.findAll();
	}
    
    @Transactional
	public Product insert(Product obj) {
		obj.setId(null);
		obj = productRepository.save(obj);
		return obj;
	}

}
