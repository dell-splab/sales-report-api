package com.api.salesreport.salesReport.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.salesreport.salesReport.Services.ClientService;
import com.api.salesreport.salesReport.entities.Client;



@RestController
@RequestMapping(value="clients")
public class ClientController {
	
	@Autowired
    private ClientService clientService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Client>> getClients() {
		
		List<Client> clients = clientService.getAllClients();
		return ResponseEntity.ok().body(clients);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok().body(client);
    }
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getClientsCount() {
        Integer clientsCount = clientService.getClientsCount();
        
        Map<String, Integer> clientsCountObj = new HashMap<>();    
        clientsCountObj.put("count", clientsCount);
        
        return ResponseEntity.ok().body(clientsCountObj);
    }
	
	
}
