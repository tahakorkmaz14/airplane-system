package com.tahakorkmaz.airplanesystem.lib.resource;

import com.tahakorkmaz.airplanesystem.lib.resource.base.BaseResource;
import lombok.Data;

@Data
public class AirportResource extends BaseResource {

    private String airportName;


    private String city;


    private String country;
}
