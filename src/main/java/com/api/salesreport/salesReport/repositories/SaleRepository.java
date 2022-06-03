package com.api.salesreport.salesReport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.salesreport.salesReport.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
