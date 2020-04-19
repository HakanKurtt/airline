package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.Flight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    List<Flight> findAll();

    List<Flight> findByAirlineCompanyId(Long airlineCompanyId);

    Optional<Flight> findById(Long theId);

    Optional<Flight> findByFlightNo(String flightNo);

    Flight save(Flight theFlight);

    void deleteById(Long theId);

    BigDecimal calculateTicketPrice(Flight flight);
}
