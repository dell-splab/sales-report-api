package com.api.salesreport.salesReport.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.salesreport.salesReport.entities.Client;
import com.api.salesreport.salesReport.entities.Sale;

import com.api.salesreport.salesReport.repositories.SaleRepository;

@Service
public class SaleService {
	 @Autowired
	 private SaleRepository saleRepository;
	 
	 public List<Sale> getAllSales() {
		return saleRepository.findAll();
	 }
	 
	 public Integer getSalesCount() {
		return saleRepository.findAll().size();
	}
	 
	public List<Sale> insertSale(Map saleObj) {
		List<Sale> sales = generateSaleObjects(saleObj);
		List<Sale> newSales = saleRepository.saveAll(sales);
		return newSales;
	}
	
	private List<Sale> generateSaleObjects(Map saleObj){
		List<Sale> sales = new ArrayList();
		
		Integer clientId = (Integer) saleObj.get("client_id");
		List<Map> items = (List) saleObj.get("items");
		
		for(Map item : items){
			Integer itemId = (Integer) item.get("product_id");
			Date date = new Date();
			Sale sale = new Sale(clientId, itemId, date);
			sales.add(sale);
		}
		
		return sales;
	}
		
}
