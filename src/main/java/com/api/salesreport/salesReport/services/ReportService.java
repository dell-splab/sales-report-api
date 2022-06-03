package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.entities.Sale;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ReportService {

    @Autowired
    private ProductRepository productRepository;

	@Autowired
	private SaleRepository saleRepository;

	public List<Product> getTopSellersAllCategories(Integer top, String window) {
		return getTopSellers(null, top, window);
	}

	public List<Product> getTopSellersByCategory(String category, Integer top, String window) {
		return getTopSellers(category, top, window);
	}

	private List<Product> getTopSellers(String category, Integer top, String window) {

		List<Sale> sales;
		if (category == null) {
			sales = saleRepository.findAll();
		}
		else {
			List<Integer> productsIds = productRepository.findAllByCategory(category)
					.stream().map(Product::getId).collect(Collectors.toList());

			sales = saleRepository.findAll().stream()
					.filter(x -> productsIds.contains(x.getProductId()))
					.collect(Collectors.toList());
		}
		
		if (!window.equals("all")) {
			sales = sales.stream().filter(x -> verifyDataSale(window, x.getCreatedAt())).collect(Collectors.toList());
		}
		
		Map<Integer, Integer> mapProductsSold = new HashMap<>();
		for (Sale s: sales) {
						
			if (!mapProductsSold.containsKey(s.getProductId())) {
				mapProductsSold.put(s.getProductId(), 0);
			}

			mapProductsSold.put(s.getProductId(), mapProductsSold.get(s.getProductId()) + 1);
		}

		List<Product> productsResult = new ArrayList<>();
		for (int i = 0; i < top; i++) {
			int highestValue = 0;
			int highestProductId = 0;
			for (Integer productId: mapProductsSold.keySet()) {

				Integer amount = mapProductsSold.get(productId);
				if (amount > highestValue) {
					highestValue = amount;
					highestProductId = productId;
				}
			}
			Optional<Product> optProduct = productRepository.findById(highestProductId);
			optProduct.ifPresent(productsResult::add);

			mapProductsSold.remove(highestProductId);
		}

		return productsResult;
	}
	
	private boolean verifyDataSale(String window, Date dateSale) {
		
		Date date = new Date();
		Calendar calToday = Calendar.getInstance();
		calToday.setTime(date);
		
		int lastYear = calToday.get(Calendar.YEAR);
		int lastMonth = calToday.get(Calendar.MONTH);
		int lastWeek = calToday.get(Calendar.WEEK_OF_YEAR);
		int lastDay = calToday.get(Calendar.DAY_OF_YEAR);
		
		Calendar calSale = Calendar.getInstance();
		calSale.setTime(dateSale);
		int saleYear = calSale.get(Calendar.YEAR);
		int saleMonth = calSale.get(Calendar.MONTH);
		int saleWeek = calSale.get(Calendar.WEEK_OF_YEAR);
		int saleDay = calSale.get(Calendar.DAY_OF_YEAR);
		
		boolean result = false;
		if (window.equals("today")) {
			if ( (lastYear == saleYear) && (lastMonth == saleMonth) && (lastWeek == saleWeek) && (lastDay == saleDay) ) {
				result = true;
			}
		}
		else if (window.equals("week")) {
			if ( (lastYear == saleYear) && (lastMonth == saleMonth) && (lastWeek == saleWeek) ) {
				result = true;
			}
		}
		else if (window.equals("month")) {
			if ( (lastYear == saleYear) && (lastMonth == saleMonth) ) {
				result = true;
			}
		}
		else if (window.equals("year")) {
			if ( (lastYear == saleYear) ) {
				System.out.println("test");
				result = true;
			}
		}
	
		
		return result;
				
	}

}
