package com.alasdeplata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alasdeplata.dto.airplane.AirplaneRequest;
import com.alasdeplata.dto.airplane.AirplaneResponse;
import com.alasdeplata.models.Airplane;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {
    AirplaneResponse toResponse(Airplane airplane);

    @Mapping(target = "id", ignore = true)
    Airplane toEntity(AirplaneRequest data);
}
