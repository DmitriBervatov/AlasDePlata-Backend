package com.alasdeplata.dto.seat;

import com.alasdeplata.enums.FlightClass;

public record SeatRequest(
        Long flightId,
        String seatNumber,
        FlightClass flightClass,
        Boolean isAvailable) {

}
