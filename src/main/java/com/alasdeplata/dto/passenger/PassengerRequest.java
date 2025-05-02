package com.alasdeplata.dto.passenger;

import java.time.LocalDate;

public record PassengerRequest(
        Long userId,
        String passportNumber,
        String nationality,
        LocalDate birthDate
) {

}
