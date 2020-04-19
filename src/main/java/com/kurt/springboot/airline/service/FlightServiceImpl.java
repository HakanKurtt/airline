package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.FlightRepository;
import com.kurt.springboot.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById(Long theId) {
        return flightRepository.findById(theId);
    }

    @Override
    public List<Flight> findByAirlineCompanyId(Long airlineCompanyId) {
        return flightRepository.findByAirlineCompanyId(airlineCompanyId);
    }

    @Override
    public Optional<Flight> findByFlightNo(String flightNo) {
        return flightRepository.findByFlightNo(flightNo);
    }

    @Override
    public Flight save(Flight theFlight) {
        return flightRepository.save(theFlight);
    }

    @Override
    public void deleteById(Long theId) {
        flightRepository.deleteById(theId);
    }

    @Override
    public BigDecimal calculateTicketPrice(Flight flight) {
        int numberOfSoldSeats = flight.getNumberOfSeats() - flight.getNumberOfAvailableSeats();
        int percentage = (int) Math.round(numberOfSoldSeats/10.0) * 10;
        BigDecimal calculatedPrice = flight.getDefaultTicketPrice().multiply(new BigDecimal(percentage)).divide(new BigDecimal(100), 2 ,1);
        BigDecimal result = flight.getDefaultTicketPrice().add(calculatedPrice);
        return result;
    }

}
