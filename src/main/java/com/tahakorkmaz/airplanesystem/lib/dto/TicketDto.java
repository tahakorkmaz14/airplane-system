package com.tahakorkmaz.airplanesystem.lib.dto;

import com.tahakorkmaz.airplanesystem.lib.dto.base.BaseDto;
import lombok.Data;

@Data
public class TicketDto extends BaseDto {

    private Long flightId;

    private String number;

    private String cardNumber;

}
