package com.tahakorkmaz.airplanesystem.lib.resource;

import com.tahakorkmaz.airplanesystem.lib.resource.base.BaseResource;
import lombok.Data;

@Data
public class TicketResource extends BaseResource {

    private String flightId;

    private String userId;

    private Double price;

    private String number;

    private String cardNumber;

}
