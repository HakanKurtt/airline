package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {

}
