package com.kurt.springboot.airline.rest.controller;

import com.kurt.springboot.airline.exception.ResourceNotFoundException;
import com.kurt.springboot.airline.model.Route;
import com.kurt.springboot.airline.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public List<Route> findAll() {
        return routeService.findAll();
    }

    @GetMapping("/route/{routeId}")
    public Optional<Route> getRoute(@PathVariable Long routeId) {
        Optional<Route> result = routeService.findById(routeId);

        Route route = null;

        if (result.isPresent()) {
            route = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @GetMapping("/route/getByOrigin")
    public List<Route> getRouteByOrigin(@RequestParam String origin) {
        return routeService.findByOrigin(origin);
    }

    @GetMapping("/route/getByDestination")
    public List<Route> getRouteByDestination(@RequestParam String destination) {
        return routeService.findByDestination(destination);
    }

    @PostMapping("/route")
    public Route save(@RequestBody Route route) {
        route.setId(null);
        routeService.save(route);
        return route;
    }

    @DeleteMapping("/route/{routeId}")
    public String deleteAirlineCompany(@PathVariable Long routeId) {
        Optional<Route> result = routeService.findById(routeId);

        Route route = null;

        if (result.isPresent()) {
            route = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        routeService.deleteById(routeId);

        return "Deleted route id - " + routeId;
    }
}
