package com.kurt.springboot.airline.service;

import com.kurt.springboot.airline.dao.TicketRepository;
import com.kurt.springboot.airline.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long theId) {
        return ticketRepository.findById(theId);
    }

    @Override
    public Optional<Ticket> findBySeatNumber(int seatNumber) {
        return ticketRepository.findBySeatNumber(seatNumber);
    }

    @Override
    public Optional<Ticket> findByTicketNo(String ticketNo) {
        return ticketRepository.findByTicketNo(ticketNo);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
