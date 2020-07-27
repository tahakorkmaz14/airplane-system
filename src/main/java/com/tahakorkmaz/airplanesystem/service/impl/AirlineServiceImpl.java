package com.tahakorkmaz.airplanesystem.service.impl;


import com.tahakorkmaz.airplanesystem.controller.mapper.AirlineMapper;
import com.tahakorkmaz.airplanesystem.data.entity.Airline;
import com.tahakorkmaz.airplanesystem.data.repository.AirlineRepository;
import com.tahakorkmaz.airplanesystem.lib.dto.AirlineDto;
import com.tahakorkmaz.airplanesystem.service.AirlineService;
import com.tahakorkmaz.airplanesystem.util.FlightManagementException;
import com.tahakorkmaz.airplanesystem.util.constants.MessageTypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirlineMapper airlineMapper;

    @Override
    public Airline create(AirlineDto airlineDto) {
        Airline airline = airlineMapper.toEntity(airlineDto);

        if (airline == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }
        airline.setCreated(new Date());

        return airlineRepository.save(airline);
    }

    @Override
    public Airline update(Long id, AirlineDto airlineDto) {
        Airline airlineToUpdate = airlineRepository.getById(id);

        if (airlineToUpdate == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        airlineToUpdate = airlineMapper.toEntity(airlineDto);
        airlineToUpdate.setId(id);
        airlineToUpdate.setUpdated(new Date());

        return airlineRepository.save(airlineToUpdate);
    }

    @Override
    public Airline delete(Long id) {
        Airline airlineToDelete = airlineRepository.getById(id);

        if (airlineToDelete == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        airlineRepository.delete(airlineToDelete);

        return airlineToDelete;
    }

    @Override
    public Airline getById(Long id) {
        Airline airline = airlineRepository.getById(id);

        if (airline == null) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return airline;
    }

    @Override
    public List<Airline> getAll() {
        List<Airline> airlines = airlineRepository.findAll();

        if (airlines.isEmpty()) {
            throw new FlightManagementException(HttpStatus.NOT_FOUND, MessageTypeConstants.NOT_FOUND);
        }

        return airlines;
    }
}
