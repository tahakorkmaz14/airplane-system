package com.tahakorkmaz.airplanesystem.controller.mapper;

import com.tahakorkmaz.airplanesystem.data.entity.Airport;
import com.tahakorkmaz.airplanesystem.lib.dto.AirportDto;
import com.tahakorkmaz.airplanesystem.lib.resource.AirportResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportMapper extends AbstractMapper<AirportDto, Airport, AirportResource> {
}
