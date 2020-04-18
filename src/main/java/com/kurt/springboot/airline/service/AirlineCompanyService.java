package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.AirlineCompany;

import java.util.List;

public interface AirlineCompanyService {

    public List<AirlineCompany> findAll();

    public AirlineCompany findById(int theId);

    public void save(AirlineCompany theAirlineCompany);

    public void deleteById(int theId);
}
