package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    List<Ticket> findAll();

    Optional<Ticket> findById(Long theId);

    Optional<Ticket> findByTicketNo(String ticketNo);

    Optional<Ticket> findBySeatNumber(int seatNumber);

    Ticket save(Ticket ticket);
}
