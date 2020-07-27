package com.tahakorkmaz.airplanesystem.controller;

import com.tahakorkmaz.airplanesystem.controller.mapper.AirportMapper;
import com.tahakorkmaz.airplanesystem.lib.dto.AirportDto;
import com.tahakorkmaz.airplanesystem.lib.resource.AirportResource;
import com.tahakorkmaz.airplanesystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @Autowired
    AirportMapper airportMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AirportResource> create(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportMapper.toResource(airportService.create(airportDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AirportResource> update(@PathVariable("id") Long id, @RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportMapper.toResource(airportService.update(id, airportDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AirportResource> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(airportMapper.toResource(airportService.delete(id)));
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<AirportResource> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(airportMapper.toResource(airportService.getById(id)));
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<AirportResource>> getAll() {
        return ResponseEntity.ok(airportMapper.toResource(airportService.getAll()));
    }
}