package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
