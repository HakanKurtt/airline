package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    List<Airport> findAll();

    Optional<Airport> findById(Long theId);

    Optional<Airport> findByName(String name);

    Airport save(Airport theAirport);

    void deleteById(Long theId);
}
