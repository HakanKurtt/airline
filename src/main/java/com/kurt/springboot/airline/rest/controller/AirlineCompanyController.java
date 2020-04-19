package com.kurt.springboot.airline.rest.controller;

import com.kurt.springboot.airline.exception.ResourceNotFoundException;
import com.kurt.springboot.airline.model.AirlineCompany;
import com.kurt.springboot.airline.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyService airlineCompanyService;

    @GetMapping("/airlineCompanies")
    public List<AirlineCompany> findAll() {
        return airlineCompanyService.findAll();
    }

    @GetMapping("/airlineCompany/{airlineCompanyId}")
    public Optional<AirlineCompany> getAirlineCompany(@PathVariable Long airlineCompanyId) {
        Optional<AirlineCompany> result = airlineCompanyService.findById(airlineCompanyId);

        AirlineCompany airlineCompany = null;

        if (result.isPresent()) {
            airlineCompany = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @GetMapping("/airlineCompany")
    public Optional<AirlineCompany> getCompanyByName(@RequestParam String name) {
        Optional<AirlineCompany> result = airlineCompanyService.findByName(name);

        AirlineCompany airlineCompany = null;

        if (result.isPresent()) {
            airlineCompany = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @PostMapping("/airlineCompany")
    public AirlineCompany save(@RequestBody AirlineCompany airlineCompany) {
        airlineCompany.setId(null);
        airlineCompanyService.save(airlineCompany);
        return airlineCompany;
    }

    @PutMapping("/airlineCompany")
    public AirlineCompany updateAirlineCompany(@RequestBody AirlineCompany airlineCompany) {
        airlineCompanyService.save(airlineCompany);
        return airlineCompany;
    }

    @DeleteMapping("/airlineCompany/{airlineCompanyId}")
    public String deleteAirlineCompany(@PathVariable Long airlineCompanyId) {
        Optional<AirlineCompany> result = airlineCompanyService.findById(airlineCompanyId);

        AirlineCompany airlineCompany = null;

        if (result.isPresent()) {
            airlineCompany = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        airlineCompanyService.deleteById(airlineCompanyId);

        return "Deleted airline company id - " + airlineCompanyId;
    }
}
