package com.tahakorkmaz.airplanesystem.service.impl;

import com.tahakorkmaz.airplanesystem.data.entity.*;
import com.tahakorkmaz.airplanesystem.data.repository.*;
import com.tahakorkmaz.airplanesystem.data.entity.*;
import com.tahakorkmaz.airplanesystem.data.repository.*;

import com.tahakorkmaz.airplanesystem.service.TicketService;
import com.tahakorkmaz.airplanesystem.util.CardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;

@Service
public class InitServiceImpl {

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    RoutesRepository routesRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;

    @PostConstruct
    public void initializeData() {
        Airline airline = createAirline("THY");
        Airport deptAirport = createAirport("Sabiha Gökçen", "İstanbul", "Türkiye");
        Airport destAirport = createAirport("Çarşamba Havaalanı", "Samsun", "Türkiye");
        Routes routes = createRoute(deptAirport, destAirport);
        Flight flight = createFlight(airline, routes, 100, 150.0);

        for (int i = 1; i <= 49; i++) {
            createTicket(flight);
        }
    }

    private Airport createAirport(String name, String city, String country) {
        Airport airport = new Airport();
        airport.setAirportName(name);
        airport.setCity(city);
        airport.setCountry(country);
        airport.setCreated(new Date());
        airport.setUpdated(new Date());

        return airportRepository.save(airport);
    }

    private Airline createAirline(String companyName) {
        Airline airline = new Airline();
        airline.setCompanyName(companyName);
        airline.setCreated(new Date());
        airline.setUpdated(new Date());

        return airlineRepository.save(airline);
    }

    private Routes createRoute(Airport from, Airport to) {
        Routes route = new Routes();
        route.setDeptAirport(from);
        route.setDestAirport(to);
        route.setDepTime(new Date());
        route.setArrTime(new Date());
        route.setCreated(new Date());
        route.setUpdated(new Date());

        return routesRepository.save(route);
    }

    private Flight createFlight(Airline airline, Routes route, Integer seats, Double ticketPrice) {
        Flight flight = new Flight();

        flight.setAirline(airline);
        flight.setRoute(route);
        flight.setSeats(seats);
        flight.setTicketPrice(ticketPrice);
        flight.setCreated(new Date());
        flight.setUpdated(new Date());

        return flightRepository.save(flight);
    }

    private Ticket createTicket(Flight flight) {
        Ticket ticket = new Ticket();
        Random randomTicketNumber = new Random();
        ticket.setNumber(String.valueOf(randomTicketNumber.nextInt(((12345 - 7420) + 1) + 7420)));
        ticket.setCardNumber(CardUtil.maskOfCardNumber("4221-1611-2233-0005"));
        ticket.setFlight(flight);
        ticket.setPrice(120.0);
        ticket.setCreated(new Date());
        ticket.setUpdated(new Date());

        return ticketRepository.save(ticket);
    }
}