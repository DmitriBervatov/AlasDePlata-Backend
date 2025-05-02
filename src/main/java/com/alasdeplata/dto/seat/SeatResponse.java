package com.alasdeplata.dto.seat;

import com.alasdeplata.enums.FlightClass;

public record SeatResponse(
        Long id,
        Long flightId,
        String seatNumber,
        FlightClass flightClass,
        Boolean isAvailable) {

}
