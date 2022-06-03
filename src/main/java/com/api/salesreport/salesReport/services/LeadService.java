package com.api.salesreport.salesReport.services;

import com.api.salesreport.salesReport.entities.Lead;
import com.api.salesreport.salesReport.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
	
	@Autowired
	private LeadRepository leadRepository;

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

}
