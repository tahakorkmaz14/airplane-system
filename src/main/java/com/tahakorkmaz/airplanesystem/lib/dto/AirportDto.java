package com.tahakorkmaz.airplanesystem.lib.dto;

import com.tahakorkmaz.airplanesystem.lib.dto.base.BaseDto;
import lombok.Data;

@Data
public class AirportDto extends BaseDto {

    private String airportName;


    private String city;


    private String country;

}
