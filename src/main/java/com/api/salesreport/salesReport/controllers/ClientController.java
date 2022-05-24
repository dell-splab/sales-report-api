package com.api.salesreport.salesReport.controllers;

import java.util.List;

import com.api.salesreport.salesReport.models.Client;
import com.api.salesreport.salesReport.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("clients")
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

}
