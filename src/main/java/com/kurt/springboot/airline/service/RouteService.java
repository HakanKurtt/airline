package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<Route> findAll();

    Optional<Route> findById(Long theId);

    List<Route> findByOrigin(String origin);

    List<Route> findByDestination(String destination);

    Route save(Route theRoute);

    void deleteById(Long theId);
}
