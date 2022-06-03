package com.api.salesreport.salesReport.controllers;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "/topsellers", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findTopSellers(@RequestParam(value = "top", defaultValue = "3") Integer top) {
		List<Product> list = reportService.getTopSellersAllCategories(top);

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/topsellers/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findTopSellersByCategory(@PathVariable String category, 
																  @RequestParam(value = "top", defaultValue = "3") Integer top) {
		List<Product> list = reportService.getTopSellersByCategory(top, category);

		return ResponseEntity.ok().body(list);
	}

}
