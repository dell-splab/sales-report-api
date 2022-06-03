package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional(readOnly=true)
    List<Product> findAllByCategory(String category);
}
