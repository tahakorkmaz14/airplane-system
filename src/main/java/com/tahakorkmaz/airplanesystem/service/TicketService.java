package com.tahakorkmaz.airplanesystem.service;


import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.data.entity.Ticket;
import com.tahakorkmaz.airplanesystem.lib.dto.TicketDto;

import java.util.List;

public interface TicketService {

    Ticket create(TicketDto ticketDto);

    Ticket update(Long id,TicketDto ticketDto);

    Ticket delete(Long id);

    Ticket getById(Long id);

    List<Ticket> getByFlight(Flight flight);

    List<Ticket> getAll();

    Ticket getByNumber(String number);

    Ticket deleteByNumber(String number);
}