package com.tahakorkmaz.airplanesystem.service;


import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.lib.dto.FlightDto;

import java.util.List;

public interface FlightService {

    Flight create(FlightDto flightDto);

    Flight update(Long id,FlightDto flightDto);

    Flight delete(Long id);

    Flight getById(Long id);

    List<Flight> getAll();
}