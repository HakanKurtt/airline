package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.Airport;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends Repository<Airport, Long> {

    List<Airport> findAll();

    Optional<Airport> findById(Long theId);

    Optional<Airport> findByName(String name);

    Airport save(Airport theAirport);

    void deleteById(Long theId);
}
