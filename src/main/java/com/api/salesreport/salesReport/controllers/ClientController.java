package com.api.salesreport.salesReport.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.salesreport.salesReport.entities.Client;
import com.api.salesreport.salesReport.services.ClientService;




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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> insertClient(@RequestBody Client clientObj){
		Client newClient = clientService.insertClient(clientObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newClient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateClient(@RequestBody Client newClientData, @PathVariable Integer id){
		newClientData.setId(id);
		
		Client newClient = clientService.updateClient(newClientData);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newClient.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newClient);
	}
	
	
}
