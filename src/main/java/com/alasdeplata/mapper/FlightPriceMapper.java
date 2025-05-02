package com.alasdeplata.mapper;

import com.alasdeplata.dto.flightprice.FlightPriceRequest;
import com.alasdeplata.dto.flightprice.FlightPriceResponse;
import com.alasdeplata.models.FlightPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlightPriceMapper {

    FlightPriceResponse toResponse(FlightPrice flightPrice);

    FlightPrice toEntity(FlightPriceRequest data);
}
