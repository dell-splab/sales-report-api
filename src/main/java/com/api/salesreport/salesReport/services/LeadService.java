package com.api.salesreport.salesReport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.salesreport.salesReport.entities.Lead;
import com.api.salesreport.salesReport.repositories.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
	private LeadRepository leadRepository;

	public List<Lead> findAll() {
		return leadRepository.findAll();
	}
}
