package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;
    

    public Product findById(Integer id) {
        Optional<Product> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
    }

}
