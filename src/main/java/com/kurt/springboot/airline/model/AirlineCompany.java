package com.kurt.springboot.airline.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class AirlineCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String city;
    private String country;
    private String postCode;

    @OneToMany(mappedBy = "airlineCompany")
    private Set<Flight> flights;

}
