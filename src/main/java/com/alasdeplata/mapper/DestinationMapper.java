package com.alasdeplata.mapper;

import javax.print.attribute.standard.Destination;

import org.mapstruct.Mapper;

import com.alasdeplata.dto.destination.DestinationRequest;
import com.alasdeplata.dto.destination.DestinationResponse;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationResponse toResponse(Destination destination);

    Destination toEntity(DestinationRequest data);
}
