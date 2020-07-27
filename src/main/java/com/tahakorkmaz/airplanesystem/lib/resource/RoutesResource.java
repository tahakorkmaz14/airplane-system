package com.tahakorkmaz.airplanesystem.lib.resource;

import com.tahakorkmaz.airplanesystem.data.entity.Airport;
import com.tahakorkmaz.airplanesystem.lib.resource.base.BaseResource;
import lombok.Data;

import java.util.Date;

@Data
public class RoutesResource extends BaseResource {

    private Date arrTime;

    private Date depTime;

    private Airport deptAirport;

    private Airport destAirport;

}