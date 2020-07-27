package com.tahakorkmaz.airplanesystem.lib.dto;

import com.tahakorkmaz.airplanesystem.lib.dto.base.BaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class RoutesDto extends BaseDto {

    private Date arrTime;

    private Date depTime;

    private Long deptAirportId;

    private Long destAirportId;

}
