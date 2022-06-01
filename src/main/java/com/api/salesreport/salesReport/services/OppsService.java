package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.dto.OppsDTO;
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
import java.util.stream.Collectors;

@Service
public class OppsService {
	
	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<OppsDTO> getOpps() {

		List<Sale> clientSales = saleRepository.findAll();
		List<Product> products = productRepository.findAll();

		Map<String, Integer> mapAmountClientPurchases = new HashMap<>();
		Map<String, Set<Product>> mapClientProducts = new HashMap<>();
		for (Sale s: clientSales) {
			Optional<Client> optClient = clientRepository.findById(s.getClientId());

			if (optClient.isPresent()) {
				String clientEmail = optClient.get().getEmail();

				if (!mapAmountClientPurchases.containsKey(clientEmail)) {
					mapAmountClientPurchases.put(clientEmail, 0);
				}
				if (!mapClientProducts.containsKey(clientEmail)) {
					mapClientProducts.put(clientEmail, new HashSet<>());
				}
				Optional<Product> optProduct = productRepository.findById(s.getProductId());

				optProduct.ifPresent(product -> mapClientProducts.get(clientEmail).add(product));

				mapAmountClientPurchases.put(clientEmail, mapAmountClientPurchases.get(clientEmail) + 1);
			}
		}

		Set<String> setFilterClientsEmails = new HashSet<>();
		for (String emailClient: mapAmountClientPurchases.keySet()) {
			if (mapAmountClientPurchases.get(emailClient) >= 2) {
				setFilterClientsEmails.add(emailClient);
			}
		}

		List<OppsDTO> listOppsDto = new ArrayList<>();
		for (String s: setFilterClientsEmails) {
			List<Product> productsCopy = new ArrayList<>(products);

			productsCopy.removeAll(mapClientProducts.get(s));
			List<String> categoriesOpps = productsCopy.stream().map(Product::getCategory).collect(Collectors.toList());

			for (Lead lead: leadRepository.findAllByEmail(s)) {
				
				Optional<Client> optClient = clientRepository.findByEmail(s);
				if (categoriesOpps.contains(lead.getSalesPage()) && optClient.isPresent()) {
					listOppsDto.add(new OppsDTO(optClient.get().getId(), lead.getSalesPage()));
				}
			}
		}

		return listOppsDto;
	}
}
