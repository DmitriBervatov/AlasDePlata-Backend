package com.alasdeplata.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alasdeplata.dto.flight.FlightDetailsResponse;
import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;
import com.alasdeplata.models.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    @Mapping(target = "airline", source = "airplane.airline.name")
    @Mapping(target = "origin", source = "origin.city")
    @Mapping(target = "destination", source = "destination.city")
    @Mapping(target = "airportCodeOrigin", source = "origin.airportCode")
    @Mapping(target = "airportCodeDestination", source = "destination.airportCode")
    @Mapping(target = "flightPrice", ignore = true)
    @Mapping(target = "duration", ignore = true)
    FlightDetailsResponse toDetailsResponse(Flight flight);

    @Mapping(target = "originId", source = "origin.id")
    @Mapping(target = "destinationId", source = "destination.id")
    @Mapping(target = "airplaneId", source = "airplane.id")
    FlightResponse toResponse(Flight flight);

    @Mapping(target = "id", ignore = true)
    Flight toEntity(FlightRequest data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFlightFromDto(FlightUpdateRequest dto, @MappingTarget Flight entity);

}
