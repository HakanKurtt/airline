package com.kurt.springboot.airline.util;

public class Generator {

    private static int ticketNumber = 100;
    private static int flightNumber = 500;

    public static String generateFlightNumber() {
        String fNo = "F"+ (++flightNumber);
        return fNo;
    }

    public static String generateTicketNumber() {
        String tNo = "T"+ (++ticketNumber);
        return tNo;
    }
}
