package com.api.salesreport.salesReport.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.salesreport.salesReport.entities.Client;

import com.api.salesreport.salesReport.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
    private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).get();
	}
	
	public Integer getClientsCount() {
		return clientRepository.findAll().size();
	}
	
	public Client insertClient(Client clientObj) {
		clientObj.setId(null);
		Client newClient = clientRepository.save(clientObj);
		return newClient;
	}
	
	public Client updateClient(Client newClientData) {
		Client client = getClientById(newClientData.getId());
		client.setName(newClientData.getName());
		return clientRepository.save(client);		
	}

	
	
}
