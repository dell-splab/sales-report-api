package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.entities.Sale;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ReportService {

    @Autowired
    private ProductRepository productRepository;

	@Autowired
	private SaleRepository saleRepository;

	public List<Product> getTopSellers() {

		List<Sale> sales = saleRepository.findAll();

		Map<Integer, Integer> mapProductsSold = new HashMap<>();

		for (Sale s: sales) {
			if (!mapProductsSold.containsKey(s.getProductId())) {
				mapProductsSold.put(s.getProductId(), 0);
			}

			mapProductsSold.put(s.getProductId(), mapProductsSold.get(s.getProductId()) + 1);
		}

		List<Product> productsResult = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int highestValue = 0;
			int highestProductId = 0;
			for (Integer productId : mapProductsSold.keySet()) {

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

}
