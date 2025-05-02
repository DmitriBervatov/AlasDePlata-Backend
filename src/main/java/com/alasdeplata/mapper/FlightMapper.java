package com.alasdeplata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.models.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightResponse toResponse(Flight flight);

    @Mapping(target = "id", ignore = true)
    Flight toEntity(FlightRequest data);
}
