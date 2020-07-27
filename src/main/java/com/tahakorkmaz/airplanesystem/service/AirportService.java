package com.tahakorkmaz.airplanesystem.service;

import com.tahakorkmaz.airplanesystem.data.entity.Airport;
import com.tahakorkmaz.airplanesystem.lib.dto.AirportDto;

import java.util.List;

public interface AirportService {

    Airport create(AirportDto airportDto);

    Airport update(Long id,AirportDto airportDto);

    Airport delete(Long id);

    Airport getById(Long id);

    List<Airport> getAll();
}