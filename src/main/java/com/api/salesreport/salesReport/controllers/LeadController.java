package com.api.salesreport.salesReport.controllers;

import com.api.salesreport.salesReport.entities.Client;
import com.api.salesreport.salesReport.entities.Lead;
import com.api.salesreport.salesReport.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/leads")
public class LeadController {
	
	@Autowired
	private LeadService leadService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Lead>> findAll() {
		List<Lead> list = leadService.findAll();
		leadService.getOpps();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{category}",method = RequestMethod.GET)
	public ResponseEntity<List<Lead>> findAllByCategory(@PathVariable String category) {
		List<Lead> list = leadService.findAllBySalesPage(category);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/opps",method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findOpps() {
		List<Client> list = leadService.getOpps();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Lead obj) {
		obj = leadService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
