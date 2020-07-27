package com.tahakorkmaz.airplanesystem.controller.mapper;

import java.util.List;

public interface AbstractMapper<Dto, Entity, Resource> {
    Entity toEntity(Dto dto);

    Resource toResource(Entity entity);

    List<Dto> toDto(List<Entity> entity);

    List<Resource> toResource(List<Entity> entities);
}
