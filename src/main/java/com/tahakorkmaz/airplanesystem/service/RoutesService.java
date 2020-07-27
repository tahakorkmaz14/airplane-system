package com.tahakorkmaz.airplanesystem.service;


import com.tahakorkmaz.airplanesystem.data.entity.Routes;
import com.tahakorkmaz.airplanesystem.lib.dto.RoutesDto;

import java.util.List;

public interface RoutesService {

    Routes create(RoutesDto routesDto);

    Routes update(Long id, RoutesDto routesDto);

    Routes delete(Long id);

    Routes getById(Long id);

    List<Routes> getAll();
}