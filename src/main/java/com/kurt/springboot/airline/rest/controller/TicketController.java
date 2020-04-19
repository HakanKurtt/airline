package com.kurt.springboot.airline.rest.controller;

import com.kurt.springboot.airline.exception.ResourceNotFoundException;
import com.kurt.springboot.airline.model.Flight;
import com.kurt.springboot.airline.model.Ticket;
import com.kurt.springboot.airline.service.FlightService;
import com.kurt.springboot.airline.service.TicketService;
import com.kurt.springboot.airline.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/tickets/{ticketNo}")
    public Optional<Ticket> getTicketByTicketNo(@PathVariable String ticketNo) {
        Optional<Ticket> result = ticketService.findByTicketNo(ticketNo);

        Ticket ticket = null;

        if (result.isPresent()) {
            ticket = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @PostMapping("/flights/{flightNo}/tickets/buyTicket")
    public Ticket buyTicket(@PathVariable (value = "flightNo") String flightNo,
                            @RequestBody Ticket ticket) {

        Optional<Flight> result = flightService.findByFlightNo(flightNo);

        Flight flight = null;

        if (result.isPresent()) {
            flight = result.get();
        } else {
            throw new ResourceNotFoundException();
        }

        if (flight.getNumberOfAvailableSeats() == 0) {
            throw new RuntimeException("All seats are sold.");
        }

        BigDecimal currentTicketPrice = flightService.calculateTicketPrice(flight);

        // check if seatNumber is taken or not
        Optional<Ticket> ticketResult= ticketService.findBySeatNumber(ticket.getSeatNumber());

        Ticket presentTicket = null;

        // Check if it is existing ticket
        if (ticketResult.isPresent()) {
            presentTicket = ticketResult.get();

            if (presentTicket.isSold()) {
                throw new RuntimeException("Ticket sold already");
            }

            // check price is sufficent
            presentTicket.setTicketPrice(ticket.getTicketPrice());

            if (!presentTicket.getTicketPrice().equals(currentTicketPrice)) {
                throw new RuntimeException("Insufficient ticket price. Please pay "+ currentTicketPrice +"$");
            }

            presentTicket.setCancelled(false);


            ticketService.save(presentTicket);

            return presentTicket;
        }

        //check if price is sufficient
        if (!ticket.getTicketPrice().equals(currentTicketPrice)) {
            throw new RuntimeException("Insufficient ticket price. Please pay "+ currentTicketPrice +"$");
        }

        flight.setNumberOfAvailableSeats(flight.getNumberOfAvailableSeats() - 1);
        flightService.save(flight);

        ticket.setFlight(flight);
        ticket.setSold(true);
        ticket.setTicketNo(Generator.generateTicketNumber());

        return ticketService.save(ticket);
    }

    @GetMapping("/flights/{flightNo}/tickets/cancelTicket/{ticketNo}")
    public String cancelTicket(@PathVariable String flightNo, @PathVariable String ticketNo) {

        Optional<Flight> flightResult = flightService.findByFlightNo(flightNo);

        Flight flight = null;

        if (flightResult.isPresent()) {
            flight = flightResult.get();
        } else {
            throw new ResourceNotFoundException();
        }

        Optional<Ticket> ticketResult = ticketService.findByTicketNo(ticketNo);

        Ticket ticket = null;

        if (ticketResult.isPresent()) {
            ticket = ticketResult.get();
        } else {
            throw new ResourceNotFoundException();
        }

        // calculate number of available of seats after cancellation
        if (flight.getNumberOfAvailableSeats() > 0) {
            flight.setNumberOfAvailableSeats(flight.getNumberOfAvailableSeats() - 1);
        }

        ticket.setSold(false);
        ticket.setCancelled(true);
        ticketService.save(ticket);

        return "Cancelled ticket no - " + ticketNo;
    }
}
