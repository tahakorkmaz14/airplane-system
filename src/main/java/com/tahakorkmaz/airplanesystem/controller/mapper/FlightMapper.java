package com.tahakorkmaz.airplanesystem.controller.mapper;

import com.tahakorkmaz.airplanesystem.data.entity.Flight;
import com.tahakorkmaz.airplanesystem.lib.dto.FlightDto;
import com.tahakorkmaz.airplanesystem.lib.resource.FlightResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends AbstractMapper<FlightDto, Flight, FlightResource>{
}
