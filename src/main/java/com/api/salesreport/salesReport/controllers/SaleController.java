package com.api.salesreport.salesReport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.salesreport.salesReport.entities.Sale;
import com.api.salesreport.salesReport.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
    private SaleService saleService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Sale>> getSales() {

		List<Sale> sales = saleService.getAllSales();
		return ResponseEntity.ok().body(sales);
	}
}
