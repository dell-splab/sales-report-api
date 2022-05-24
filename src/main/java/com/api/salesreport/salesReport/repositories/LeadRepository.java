package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.models.Lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
