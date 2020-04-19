package com.kurt.springboot.airline.rest.controller;

import com.kurt.springboot.airline.exception.ResourceNotFoundException;
import com.kurt.springboot.airline.model.Airport;
import com.kurt.springboot.airline.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public List<Airport> findAll() {
        return airportService.findAll();
    }

    @GetMapping("/airport/{airportId}")
    public Optional<Airport> getAirport(@PathVariable Long airportId) {
        Optional<Airport> result = airportService.findById(airportId);

        Airport airport = null;

        if (result.isPresent()) {
            airport = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @GetMapping("/airport")
    public Optional<Airport> getAirportByName(@RequestParam String name) {
        Optional<Airport> result = airportService.findByName(name);

        Airport airport = null;

        if (result.isPresent()) {
            airport = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @PostMapping("/airport")
    public Airport save(@RequestBody Airport airport) {
        airport.setId(null);
        airportService.save(airport);
        return airport;
    }

    @PutMapping("/airport")
    public Airport updateAirport(@RequestBody Airport airport) {
        airportService.save(airport);
        return airport;
    }

    @DeleteMapping("/airport/{airportId}")
    public String deleteAirlineCompany(@PathVariable Long airportId) {
        Optional<Airport> result = airportService.findById(airportId);

        Airport airport = null;

        if (result.isPresent()) {
            airport = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        airportService.deleteById(airportId);

        return "Deleted airport id - " + airportId;
    }
}

