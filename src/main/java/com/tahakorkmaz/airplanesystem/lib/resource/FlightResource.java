package com.tahakorkmaz.airplanesystem.lib.resource;

import com.tahakorkmaz.airplanesystem.data.entity.Airline;
import com.tahakorkmaz.airplanesystem.data.entity.Routes;
import com.tahakorkmaz.airplanesystem.lib.resource.base.BaseResource;
import lombok.Data;

import java.util.Date;

@Data
public class FlightResource extends BaseResource {

    private Airline airline;

    private Routes routes;

    private Integer seats;

    private Date date;

    private Double ticketPrice;

}
