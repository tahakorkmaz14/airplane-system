package com.tahakorkmaz.airplanesystem.service.impl;


import com.tahakorkmaz.airplanesystem.controller.mapper.AirportMapper;
import com.tahakorkmaz.airplanesystem.data.repository.AirportRepository;
import com.tahakorkmaz.airplanesystem.util.constants.MessageTypeConstants;
import com.tahakorkmaz.airplanesystem.data.entity.Airport;
import com.tahakorkmaz.airplanesystem.lib.dto.AirportDto;
import com.tahakorkmaz.airplanesystem.service.AirportService;
import com.tahakorkmaz.airplanesystem.util.FlightManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportMapper airportMapper;

    @Override
    public Airport create(AirportDto airportDto) {
        Airport airport = airportMapper.toEntity(airportDto);

        if (airport == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }
        airport.setCreated(new Date());

        return airportRepository.save(airport);
    }

    @Override
    public Airport update(Long id, AirportDto airportDto) {
        Airport airportToUpdate = airportRepository.getById(id);

        if (airportToUpdate == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        airportToUpdate = airportMapper.toEntity(airportDto);
        airportToUpdate.setId(id);
        airportToUpdate.setUpdated(new Date());

        return airportRepository.save(airportToUpdate);
    }

    @Override
    public Airport delete(Long id) {
        Airport airportToDelete = airportRepository.getById(id);

        if (airportToDelete == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        airportRepository.delete(airportToDelete);

        return airportToDelete;
    }

    @Override
    public Airport getById(Long id) {
        Airport airport = airportRepository.getById(id);

        if (airport == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return airport;
    }

    @Override
    public List<Airport> getAll() {
        List<Airport> airports = airportRepository.findAll();

        if (airports.isEmpty()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return airports;
    }
}