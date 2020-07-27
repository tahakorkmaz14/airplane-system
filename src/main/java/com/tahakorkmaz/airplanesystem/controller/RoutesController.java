package com.tahakorkmaz.airplanesystem.controller;

import com.tahakorkmaz.airplanesystem.controller.mapper.RoutesMapper;
import com.tahakorkmaz.airplanesystem.lib.resource.RoutesResource;
import com.tahakorkmaz.airplanesystem.lib.dto.RoutesDto;
import com.tahakorkmaz.airplanesystem.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RoutesController {

    @Autowired
    RoutesService routesService;

    @Autowired
    RoutesMapper routesMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RoutesResource> create(@RequestBody RoutesDto routesDto) {
        return ResponseEntity.ok(routesMapper.toResource(routesService.create(routesDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RoutesResource> update(@PathVariable("id") Long id, @RequestBody RoutesDto routesDto) {
        return ResponseEntity.ok(routesMapper.toResource(routesService.update(id, routesDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RoutesResource> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(routesMapper.toResource(routesService.delete(id)));
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoutesResource> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(routesMapper.toResource(routesService.getById(id)));
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<RoutesResource>> getAll() {
        return ResponseEntity.ok(routesMapper.toResource(routesService.getAll()));
    }
}