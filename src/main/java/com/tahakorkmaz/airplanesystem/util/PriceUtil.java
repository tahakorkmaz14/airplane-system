package com.tahakorkmaz.airplanesystem.util;

import com.tahakorkmaz.airplanesystem.data.entity.Flight;

public class PriceUtil {

    public static Double calculatePrice(Flight flight, Integer sumOfTicket) {
        float capacity = flight.getSeats();
        int percent = (int) (((sumOfTicket + 1) * 100.0f) / capacity);
        int percentMultiple = percent / 10;

        return (flight.getTicketPrice() * (percentMultiple * 10)) / 100;
    }
}