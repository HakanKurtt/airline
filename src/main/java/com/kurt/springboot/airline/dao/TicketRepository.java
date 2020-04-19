package com.kurt.springboot.airline.dao;

import com.kurt.springboot.airline.model.Ticket;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends Repository<Ticket, Long> {

    List<Ticket> findAll();

    Optional<Ticket> findById(Long theId);

    Optional<Ticket> findByTicketNo(String ticketNo);

    Optional<Ticket> findBySeatNumber(int seatNumber);

    Ticket save(Ticket ticket);
}
