package com.tahakorkmaz.airplanesystem.data.repository;

import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.data.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {

    Ticket getById(Long id);

    List<Ticket> getByFlight(Flight flight);

    Ticket getByNumber(String number);

}
