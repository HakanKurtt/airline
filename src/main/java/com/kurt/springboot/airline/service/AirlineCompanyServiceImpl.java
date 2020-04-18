package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.AirlineCompanyRepository;
import com.kurt.springboot.airline.model.AirlineCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    public AirlineCompanyServiceImpl(AirlineCompanyRepository theAirlineCompanyRepository) {
        airlineCompanyRepository = theAirlineCompanyRepository;
    }

    @Override
    public List<AirlineCompany> findAll() {
        return airlineCompanyRepository.findAll();
    }

    @Override
    public AirlineCompany findById(int theId) {
        return null;
    }

    @Override
    public void save(AirlineCompany theAirlineCompany) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
