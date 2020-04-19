package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.AirlineCompany;

import java.util.List;
import java.util.Optional;

public interface AirlineCompanyService {

    List<AirlineCompany> findAll();

    Optional<AirlineCompany> findById(Long theId);

    Optional<AirlineCompany> findByName(String name);

    AirlineCompany save(AirlineCompany theAirlineCompany);

    void deleteById(Long theId);
}
