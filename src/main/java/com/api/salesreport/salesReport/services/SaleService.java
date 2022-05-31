package com.api.salesreport.salesReport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.salesreport.salesReport.entities.Sale;

import com.api.salesreport.salesReport.repositories.SaleRepository;

@Service
public class SaleService {
	 @Autowired
	 private SaleRepository saleRepository;
	 
	 public List<Sale> getAllSales() {
		return saleRepository.findAll();
	 }
}
