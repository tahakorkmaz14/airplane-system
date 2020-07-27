package com.tahakorkmaz.airplanesystem.controller;

import com.tahakorkmaz.airplanesystem.controller.mapper.FlightMapper;
import com.tahakorkmaz.airplanesystem.lib.dto.FlightDto;
import com.tahakorkmaz.airplanesystem.lib.resource.FlightResource;
import com.tahakorkmaz.airplanesystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    FlightService flightService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FlightResource> create(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightMapper.toResource(flightService.create(flightDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FlightResource> update(@PathVariable("id") Long id, @RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightMapper.toResource(flightService.update(id,flightDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FlightResource> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(flightMapper.toResource(flightService.delete(id)));
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<FlightResource> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(flightMapper.toResource(flightService.getById(id)));
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<FlightResource>> getAll() {
        return ResponseEntity.ok(flightMapper.toResource(flightService.getAll()));
    }
}