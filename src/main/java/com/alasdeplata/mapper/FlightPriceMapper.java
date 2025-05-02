package com.alasdeplata.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alasdeplata.dto.flightprice.FlightPriceRequest;
import com.alasdeplata.dto.flightprice.FlightPriceResponse;
import com.alasdeplata.dto.flightprice.FlightPriceUpdateRequest;
import com.alasdeplata.models.FlightPrice;

@Mapper(componentModel = "spring")
public interface FlightPriceMapper {

    FlightPriceResponse toResponse(FlightPrice flightPrice);

    FlightPrice toEntity(FlightPriceRequest data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFlightPriceFromDto(FlightPriceUpdateRequest dto, @MappingTarget FlightPrice entity);
}
