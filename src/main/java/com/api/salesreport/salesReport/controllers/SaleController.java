package com.api.salesreport.salesReport.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getSalesCount() {
        Integer salesCount = saleService.getSalesCount();
        
        Map<String, Integer> salesCountObj = new HashMap<>();    
        salesCountObj.put("count", salesCount);
        
        return ResponseEntity.ok().body(salesCountObj);
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> insertSales(@RequestBody Map saleObj){
		saleService.insertSale(saleObj);
		return ResponseEntity.noContent().build();
	}
}
