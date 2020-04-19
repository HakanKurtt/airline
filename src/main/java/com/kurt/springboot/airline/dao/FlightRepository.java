package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.Flight;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends Repository<Flight, Long> {

    List<Flight> findAll();

    List<Flight> findByAirlineCompanyId(Long airlineCompanyId);

    Optional<Flight> findById(Long theId);

    Optional<Flight> findByFlightNo(String flightNo);

    Flight save(Flight theFlight);

    void deleteById(Long theId);
}
