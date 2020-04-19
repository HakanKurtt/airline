package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.RouteRepository;
import com.kurt.springboot.airline.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> findById(Long theId) {
        return routeRepository.findById(theId);
    }

    @Override
    public List<Route> findByOrigin(String origin) {
        return routeRepository.findByOrigin(origin);
    }

    @Override
    public List<Route> findByDestination(String destination) {
        return routeRepository.findByDestination(destination);
    }

    @Override
    public Route save(Route theRoute) {
        return routeRepository.save(theRoute);
    }

    @Override
    public void deleteById(Long theId) {
        routeRepository.deleteById(theId);
    }
}
