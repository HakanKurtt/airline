package com.kurt.springboot.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNo;

    private int numberOfSeats;
    private int numberOfAvailableSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "airline_company_id")
    @JsonIgnore
    private AirlineCompany airlineCompany;

    @OneToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private List<Ticket> ticketList;

    @Transient
    @JsonIgnore
    private BigDecimal defaultTicketPrice = new BigDecimal(1000.00);

}
