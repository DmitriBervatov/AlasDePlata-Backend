package com.alasdeplata.mapper;

import com.alasdeplata.dto.reservationpassenger.ReservationPassengerRequest;
import com.alasdeplata.dto.reservationpassenger.ReservationPassengerResponse;
import com.alasdeplata.models.ReservationPassenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationPassengerMapper {
    ReservationPassengerResponse toResponse(ReservationPassenger reservationPassenger);

    ReservationPassenger toEntity(ReservationPassengerRequest data);
}
