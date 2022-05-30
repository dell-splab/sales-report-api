package com.api.salesreport.salesReport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.salesreport.salesReport.entities.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
	
	@Transactional(readOnly=true)
	List<Lead> findAllBySalesPage(String salesPage);
}
