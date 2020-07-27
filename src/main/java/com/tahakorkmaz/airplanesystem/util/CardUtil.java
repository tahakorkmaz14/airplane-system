package com.tahakorkmaz.airplanesystem.util;

import com.tahakorkmaz.airplanesystem.util.constants.MessageTypeConstants;
import org.springframework.http.HttpStatus;

public class CardUtil {

    public static String maskOfCardNumber(String cardNumber) {
        cardNumber = cardNumber.trim();
        cardNumber = cardNumber.replaceAll("[^0-9]+", "");

        if (cardNumber.length() > 16) {
            throw new FlightManagementException(HttpStatus.BAD_REQUEST, MessageTypeConstants.CARD_LIMITS_EXCEEDED);
        }

        cardNumber = cardNumber.replaceAll(cardNumber.substring(4, 12), "********");

        return cardNumber;
    }
}