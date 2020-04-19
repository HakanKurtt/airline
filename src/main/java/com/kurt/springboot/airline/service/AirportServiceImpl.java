package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.AirportRepository;
import com.kurt.springboot.airline.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> findById(Long theId) {
        return airportRepository.findById(theId);
    }

    @Override
    public Optional<Airport> findByName(String name) {
        return airportRepository.findByName(name);
    }

    @Override
    public Airport save(Airport theAirport) {
        return airportRepository.save(theAirport);
    }

    @Override
    public void deleteById(Long theId) {
        airportRepository.deleteById(theId);
    }
}
