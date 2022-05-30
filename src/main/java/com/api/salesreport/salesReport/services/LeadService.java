package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Client;
import com.api.salesreport.salesReport.entities.Lead;
import com.api.salesreport.salesReport.entities.Product;
import com.api.salesreport.salesReport.entities.Sale;
import com.api.salesreport.salesReport.repositories.ClientRepository;
import com.api.salesreport.salesReport.repositories.LeadRepository;
import com.api.salesreport.salesReport.repositories.ProductRepository;
import com.api.salesreport.salesReport.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeadService {
	
	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Lead> findAll() {
		return leadRepository.findAll();
	}
	
	public List<Lead> findAllBySalesPage(String salesPage) {
		return leadRepository.findAllBySalesPage(salesPage);
	}
	
	public Lead insert(Lead obj) {
		obj.setId(null);
		obj = leadRepository.save(obj);
		return obj;
	}

	public List<Client> getOpps() {

		List<Sale> clientSales = saleRepository.findAll();

		Map<String, Integer> mapClientSales = new HashMap<>();
		Map<String, Set<String>> mapClientCategories = new HashMap<>();
		for (Sale s: clientSales) {
			if (clientRepository.findById(s.getClientId()).isPresent()) {
				String clientEmail = clientRepository.findById(s.getClientId()).get().getEmail();

				if (!mapClientSales.containsKey(clientEmail)) {
					mapClientSales.put(clientEmail, 0);
				}
				if (!mapClientCategories.containsKey(clientEmail)) {
					mapClientCategories.put(clientEmail, new HashSet<>());
				}
				Optional<Product> optProduct = productRepository.findById(s.getProductId());

				optProduct.ifPresent(product -> mapClientCategories.get(clientEmail).add(product.getCategory()));

				mapClientSales.put(clientEmail, mapClientSales.get(clientEmail) + 1);
			}

		}

		Set<String> setFilterClientsEmails = new HashSet<>();
		for (String emailClient: mapClientSales.keySet()) {
			if (mapClientSales.get(emailClient) >= 2) {
				setFilterClientsEmails.add(emailClient);
			}
		}


		List<Client> clients = new ArrayList<>();
		for (String s: setFilterClientsEmails) {
			if (!mapClientCategories.get(s).contains(leadRepository.findByEmail(s).getSalesPage())) {
				clients.add(clientRepository.findByEmail(s));
			}
		}

		return clients;
	}
}
