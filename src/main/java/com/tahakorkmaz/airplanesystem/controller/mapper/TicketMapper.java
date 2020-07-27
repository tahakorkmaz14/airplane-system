package com.tahakorkmaz.airplanesystem.controller.mapper;

import com.tahakorkmaz.airplanesystem.data.entity.Ticket;
import com.tahakorkmaz.airplanesystem.lib.dto.TicketDto;
import com.tahakorkmaz.airplanesystem.lib.resource.TicketResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper extends AbstractMapper<TicketDto, Ticket, TicketResource> {
}
