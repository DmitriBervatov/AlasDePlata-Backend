package com.alasdeplata.mapper;

import org.mapstruct.Mapper;
import com.alasdeplata.dto.airline.AirlineRequest;
import com.alasdeplata.dto.airline.AirlineResponse;
import com.alasdeplata.dto.airline.AirlineUpdateRequest;
import com.alasdeplata.models.Airline;

@Mapper(componentModel = "spring")
public interface AirlineMapper {

    AirlineResponse toResponse(Airline airline);

    @Mapping(target = "id", ignore = true)
    Airline toEntity(AirlineRequest data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAirlineFromDto(AirlineUpdateRequest item, @MappingTarget Airline airline);

}
