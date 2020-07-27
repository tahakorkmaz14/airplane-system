package com.tahakorkmaz.airplanesystem.service.impl;


import com.tahakorkmaz.airplanesystem.controller.mapper.FlightMapper;
import com.tahakorkmaz.airplanesystem.data.repository.FlightRepository;
import com.tahakorkmaz.airplanesystem.util.constants.MessageTypeConstants;
import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.lib.dto.FlightDto;
import com.tahakorkmaz.airplanesystem.service.AirlineService;
import com.tahakorkmaz.airplanesystem.service.FlightService;
import com.tahakorkmaz.airplanesystem.service.RoutesService;
import com.tahakorkmaz.airplanesystem.util.FlightManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    AirlineService airlineService;

    @Autowired
    RoutesService routesService;

    @Override
    public Flight create(FlightDto flightDto) {
        Flight flight;

        flight = flightMapper.toEntity(flightDto);
        flight.setAirline(airlineService.getById(flightDto.getAirlineId()));
        flight.setRoute(routesService.getById(flightDto.getRoutesId()));

        flight.setCreated(new Date());
        flight.setUpdated(new Date());

        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Long id, FlightDto flightDto) {
        Flight flightToUpdate = flightRepository.getById(id);

        if (flightToUpdate == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        flightToUpdate = flightMapper.toEntity(flightDto);
        flightToUpdate.setAirline(airlineService.getById(flightDto.getAirlineId()));
        flightToUpdate.setRoute(routesService.getById(flightDto.getRoutesId()));

        flightToUpdate.setUpdated(new Date());


        return flightRepository.save(flightToUpdate);
    }

    @Override
    public Flight delete(Long id) {
        Flight flightToDelete = flightRepository.getById(id);

        if (flightToDelete == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        flightRepository.delete(flightToDelete);

        return flightToDelete;
    }

    @Override
    public Flight getById(Long id) {
        Flight flight = flightRepository.getById(id);

        if (flight == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return flight;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = flightRepository.findAll();

        if (flights.isEmpty()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return flights;
    }
}
