package com.kurt.springboot.airline.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kurt.springboot.airline.exception.ResourceNotFoundException;
import com.kurt.springboot.airline.model.AirlineCompany;
import com.kurt.springboot.airline.model.Flight;
import com.kurt.springboot.airline.service.AirlineCompanyService;
import com.kurt.springboot.airline.service.FlightService;
import com.kurt.springboot.airline.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineCompanyService airlineCompanyService;

    @GetMapping("/flights")
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("/flights/{flightId}")
    public Optional<Flight> getFlight(@PathVariable Long flightId) {
        Optional<Flight> result = flightService.findById(flightId);

        Flight flight = null;

        if (result.isPresent()) {
            flight = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @GetMapping("/airlineCompany/{airlineCompanyId}/flights")
    public List<Flight> getAllFlightsByAirlineCompanyId(@PathVariable (value = "airlineCompanyId") Long airlineCompanyId) {
        return flightService.findByAirlineCompanyId(airlineCompanyId);
    }

    @GetMapping("/flight")
    public Optional<Flight> getFlightByFlightNo(@RequestParam String flightNo) {
        Optional<Flight> result = flightService.findByFlightNo(flightNo);

        Flight flight = null;

        if (result.isPresent()) {
            flight = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @PostMapping("/airlineCompanies/{airlineCompanyId}/flights")
    public Flight createFlight(@PathVariable (value = "airlineCompanyId") Long airlineCompanyId,
                                 @RequestBody Flight flight) {

        Optional<AirlineCompany> result = airlineCompanyService.findById(airlineCompanyId);

        AirlineCompany airlineCompany = null;

        if (result.isPresent()) {
            airlineCompany = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        flight.setAirlineCompany(airlineCompany);

        flight.setFlightNo(Generator.generateFlightNumber());

        return flightService.save(flight);
    }

    @GetMapping("/flights/{flightNo}/getTicketPrice")
    public String getTicketPrice(@PathVariable String flightNo) {
        Optional<Flight> result = flightService.findByFlightNo(flightNo);

        Flight flight = null;

        if (result.isPresent()) {
            flight = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        Map<String,String> myMap = new HashMap<String, String>();

        myMap.put("flightNo", flightNo);
        myMap.put("ticketPrice", flightService.calculateTicketPrice(flight).toString());
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(myMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @DeleteMapping("/flight/{flightId}")
    public String deleteFlight(@PathVariable Long flightId) {
        Optional<Flight> result = flightService.findById(flightId);

        Flight flight = null;

        if (result.isPresent()) {
            flight = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        flightService.deleteById(flightId);

        return "Deleted flight id - " + flightId;
    }
}
