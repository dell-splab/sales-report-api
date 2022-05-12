package com.api.salesreport.salesReport.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("status")
    public String status() {
        return "Back-end Sales Report is running.";
    }
}
