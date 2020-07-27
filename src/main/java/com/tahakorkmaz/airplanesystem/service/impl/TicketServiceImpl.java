package com.tahakorkmaz.airplanesystem.service.impl;

import com.tahakorkmaz.airplanesystem.controller.mapper.TicketMapper;
import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.data.entity.Ticket;
import com.tahakorkmaz.airplanesystem.data.repository.TicketRepository;
import com.tahakorkmaz.airplanesystem.lib.dto.TicketDto;
import com.tahakorkmaz.airplanesystem.service.FlightService;
import com.tahakorkmaz.airplanesystem.service.TicketService;
import com.tahakorkmaz.airplanesystem.util.FlightManagementException;
import com.tahakorkmaz.airplanesystem.util.PriceUtil;
import com.tahakorkmaz.airplanesystem.util.CardUtil;
import com.tahakorkmaz.airplanesystem.util.constants.MessageTypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    FlightService flightService;

    @Override
    public Ticket create(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        Flight flight = flightService.getById(ticketDto.getFlightId());

        if (ticket == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        if (getByFlight(flight).size() > flight.getSeats()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_A_SEATS);
        }


        ticket.setFlight(flight);
        ticket.setCardNumber(CardUtil.maskOfCardNumber(ticket.getCardNumber()));

        ticket.setPrice(flight.getTicketPrice() + PriceUtil.calculatePrice(flight, getByFlight(flight).size()));
        ticket.setCreated(new Date());

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Long id, TicketDto ticketDto) {
        Ticket ticketToUpdate = ticketRepository.getById(id);
        Flight flight = flightService.getById(ticketDto.getFlightId());

        if (ticketToUpdate == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        if (getByFlight(flight).size() > flight.getSeats()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_A_SEATS);
        }

        ticketToUpdate = ticketMapper.toEntity(ticketDto);
        ticketToUpdate.setFlight(flight);
        ticketToUpdate.setId(id);
        ticketToUpdate.setPrice(flight.getTicketPrice() + PriceUtil.calculatePrice(flight, getByFlight(flight).size()));
        ticketToUpdate.setCardNumber(CardUtil.maskOfCardNumber(ticketToUpdate.getCardNumber()));
        ticketToUpdate.setUpdated(new Date());

        return ticketRepository.save(ticketToUpdate);
    }

    @Override
    public Ticket delete(Long id) {
        Ticket ticketToDelete = ticketRepository.getById(id);

        if (ticketToDelete == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        ticketRepository.delete(ticketToDelete);

        return ticketToDelete;
    }

    @Override
    public Ticket deleteByNumber(String number) {
        Ticket ticketToDelete = ticketRepository.getByNumber(number);

        if (ticketToDelete == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        ticketRepository.delete(ticketToDelete);

        return ticketToDelete;
    }

    @Override
    public Ticket getById(Long id) {
        Ticket ticket = ticketRepository.getById(id);

        if (ticket == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = ticketRepository.findAll();

        if (tickets.isEmpty()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return tickets;
    }

    @Override
    public List<Ticket> getByFlight(Flight flight) {
        List<Ticket> tickets = ticketRepository.getByFlight(flight);

        if (tickets.isEmpty()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return tickets;
    }

    @Override
    public Ticket getByNumber(String number) {
        Ticket ticket = ticketRepository.getByNumber(number);

        if (ticket == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return ticket;
    }
}