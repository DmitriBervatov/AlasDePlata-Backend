package com.alasdeplata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alasdeplata.dto.passenger.PassengerRequest;
import com.alasdeplata.dto.passenger.PassengerResponse;
import com.alasdeplata.models.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerResponse toResponse(Passenger passenger);

    @Mapping(target = "id", ignore = true)
    Passenger toEntity(PassengerRequest data);
}
