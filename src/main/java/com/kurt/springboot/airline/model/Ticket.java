package com.kurt.springboot.airline.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue
    private String ticketNo;

    private BigDecimal ticketPrice;
    private int seatNumber;
    private boolean isSold = false;
    private boolean isCancelled = false;

    @ManyToOne
    private Flight flight;
}
