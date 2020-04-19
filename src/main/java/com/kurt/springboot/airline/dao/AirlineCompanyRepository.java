package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AirlineCompanyRepository extends Repository<AirlineCompany, Long> {

    List<AirlineCompany> findAll();

    Optional<AirlineCompany> findById(Long theId);

    Optional<AirlineCompany> findByName(String name);

    AirlineCompany save(AirlineCompany theAirlineCompany);

    void deleteById(Long theId);
}
