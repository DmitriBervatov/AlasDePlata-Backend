package com.alasdeplata.dto.seat;

import com.alasdeplata.enums.FlightClass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeatRequest(
                @NotNull Long flightId,
                @NotBlank String seatNumber,
                @NotNull FlightClass flightClass,
                @NotNull Boolean isAvailable) {

}
