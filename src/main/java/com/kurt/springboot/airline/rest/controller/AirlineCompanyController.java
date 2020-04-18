package com.kurt.springboot.airline.rest.controller;

import com.kurt.springboot.airline.model.AirlineCompany;
import com.kurt.springboot.airline.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyService airlineCompanyService;

    @GetMapping("/airlineCompanies")
    public List<AirlineCompany> findAll() {
        return airlineCompanyService.findAll();
    }
}
