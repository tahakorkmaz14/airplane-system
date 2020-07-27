package com.tahakorkmaz.airplanesystem.service;

import com.tahakorkmaz.airplanesystem.data.entity.Airline;
import com.tahakorkmaz.airplanesystem.lib.dto.AirlineDto;

import java.util.List;

public interface AirlineService {

    Airline create(AirlineDto airlineDto);

    Airline update(Long id,AirlineDto airlineDto);

    Airline delete(Long id);

    Airline getById(Long id);

    List<Airline> getAll();
}