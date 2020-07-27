package com.tahakorkmaz.airplanesystem.controller.mapper;

import com.tahakorkmaz.airplanesystem.data.entity.Airline;
import com.tahakorkmaz.airplanesystem.lib.dto.AirlineDto;
import com.tahakorkmaz.airplanesystem.lib.resource.AirlineResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineMapper extends AbstractMapper<AirlineDto, Airline, AirlineResource>{
}
