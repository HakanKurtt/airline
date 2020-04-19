package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.AirlineCompanyRepository;
import com.kurt.springboot.airline.model.AirlineCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @Override
    public List<AirlineCompany> findAll() {
        return airlineCompanyRepository.findAll();
    }

    @Override
    public Optional<AirlineCompany> findById(Long theId) {
        return airlineCompanyRepository.findById(theId);
    }

    @Override
    public Optional<AirlineCompany> findByName(String name) {
        return airlineCompanyRepository.findByName(name);
    }

    @Override
    public AirlineCompany save(AirlineCompany theAirlineCompany) {
        return airlineCompanyRepository.save(theAirlineCompany);
    }

    @Override
    public void deleteById(Long theId) {
        airlineCompanyRepository.deleteById(theId);
    }
}
