package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.AirlineCompany;

import java.util.List;
import java.util.Optional;

public interface AirlineCompanyService {

    public List<AirlineCompany> findAll();

    public Optional<AirlineCompany> findById(Long theId);

    public AirlineCompany save(AirlineCompany theAirlineCompany);

    public void deleteById(Long theId);
}
