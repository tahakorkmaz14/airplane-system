package com.tahakorkmaz.airplanesystem.controller.mapper;

import com.tahakorkmaz.airplanesystem.data.entity.Routes;
import com.tahakorkmaz.airplanesystem.lib.dto.RoutesDto;
import com.tahakorkmaz.airplanesystem.lib.resource.RoutesResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoutesMapper extends AbstractMapper<RoutesDto, Routes, RoutesResource>{
}
