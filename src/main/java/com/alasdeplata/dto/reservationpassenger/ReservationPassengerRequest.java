package com.alasdeplata.dto.reservationpassenger;

public record ReservationPassengerRequest(
        Long reservationId,
        Long passengerId,
        Long seatId) {

}
