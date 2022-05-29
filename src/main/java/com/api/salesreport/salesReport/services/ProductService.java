package com.api.salesreport.salesReport.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.services.exceptions.DataIntegrityException;
import com.api.salesreport.salesReport.services.exceptions.ObjectNotFoundException;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        		String.format("Product with id %s was not found", id)));
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
    
    public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return productRepository.save(newObj);
	}
    
    public void delete(Integer id) {
    	findById(id);
		try {
			productRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are sales related to this product.");
		}
	}
    
    private void updateData(Product newObj, Product obj) {		
		
    	if (obj.getName() != null) {
			newObj.setName(obj.getName());
		}
		
		if (obj.getPrice() != null) {
			newObj.setPrice(obj.getPrice());
		}
		
		if (obj.getCategory() != null) {
			newObj.setCategory(obj.getCategory());
		}
		
		if (obj.getDescription() != null) {
			newObj.setDescription(obj.getDescription());
		}
	}

}
