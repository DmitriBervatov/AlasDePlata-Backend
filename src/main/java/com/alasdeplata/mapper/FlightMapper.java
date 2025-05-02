package com.alasdeplata.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;
import com.alasdeplata.models.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    @Mapping(target = "originId", source = "origin.id")
    @Mapping(target = "destinationId", source = "destination.id")
    @Mapping(target = "airlineId", source = "airplane.id")
    FlightResponse toResponse(Flight flight);

    @Mapping(target = "id", ignore = true)
    Flight toEntity(FlightRequest data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFlightFromDto(FlightUpdateRequest dto, @MappingTarget Flight entity);

}
