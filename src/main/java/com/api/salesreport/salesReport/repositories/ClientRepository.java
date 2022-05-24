package com.api.salesreport.salesReport.repositories;

import com.api.salesreport.salesReport.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
