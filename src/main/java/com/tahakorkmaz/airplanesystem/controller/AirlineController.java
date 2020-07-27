package com.tahakorkmaz.airplanesystem.controller;

import com.tahakorkmaz.airplanesystem.controller.mapper.AirlineMapper;
import com.tahakorkmaz.airplanesystem.lib.dto.AirlineDto;
import com.tahakorkmaz.airplanesystem.lib.resource.AirlineResource;
import com.tahakorkmaz.airplanesystem.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirlineMapper airlineMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AirlineResource> create(@RequestBody AirlineDto airlineDto) {
        return ResponseEntity.ok(airlineMapper.toResource(airlineService.create(airlineDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AirlineResource> update(@PathVariable("id") Long id, @RequestBody AirlineDto airlineDto) {
        return ResponseEntity.ok(airlineMapper.toResource(airlineService.update(id,airlineDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AirlineResource> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(airlineMapper.toResource(airlineService.delete(id)));
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<AirlineResource> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(airlineMapper.toResource(airlineService.getById(id)));
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<AirlineResource>> getAll() {
        return ResponseEntity.ok(airlineMapper.toResource(airlineService.getAll()));
    }
}