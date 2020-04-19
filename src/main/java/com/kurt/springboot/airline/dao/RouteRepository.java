package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.Route;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends Repository<Route, Long> {

    List<Route> findAll();

    Optional<Route> findById(Long theId);

    List<Route> findByOrigin(String origin);

    List<Route> findByDestination(String destination);

    Route save(Route theRoute);

    void deleteById(Long theId);
}
