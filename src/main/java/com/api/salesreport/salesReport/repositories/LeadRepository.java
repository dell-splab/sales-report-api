package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.entities.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

	@Transactional(readOnly=true)
	Lead findByEmail(String email);

	@Transactional(readOnly=true)
	List<Lead> findAllBySalesPage(String salesPage);
}
