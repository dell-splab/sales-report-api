package com.api.salesreport.salesReport.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.salesreport.salesReport.entities.Lead;
import com.api.salesreport.salesReport.services.LeadService;

@RestController
@RequestMapping(value = "/leads")
public class LeadController {
	
	@Autowired
	private LeadService leadService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Lead>> findAll() {
		List<Lead> list = leadService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
