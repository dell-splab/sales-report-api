package com.api.salesreport.salesReport.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.api.salesreport.salesReport.entities.Client;

import com.api.salesreport.salesReport.repositories.ClientRepository;
import com.api.salesreport.salesReport.services.exceptions.DataIntegrityException;
import com.api.salesreport.salesReport.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	@Autowired
    private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client getClientById(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow(() -> new ObjectNotFoundException(
        		String.format("Product with id %s was not found", id)));
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
		updateClientData(newClientData, client);
		
		return clientRepository.save(client);		
	}
	
	public void deleteClient(Integer id) {
		getClientById(id);
		try {
			clientRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are sales related to this product.");
		}	
	}
	
	
	private void updateClientData(Client newClientData, Client client) {
		if (newClientData.getName() != null && !newClientData.getName().isEmpty()) {
			client.setName(newClientData.getName());
		}
		if (newClientData.getEmail() != null && !newClientData.getEmail().isEmpty()) {
			client.setEmail(newClientData.getEmail());
		}
	}
	
}
