package com.api.salesreport.salesReport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.salesreport.salesReport.entities.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
}
