package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.models.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
