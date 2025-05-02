package com.alasdeplata.dto.flightprice;

import java.math.BigDecimal;

import com.alasdeplata.enums.FlightClass;

public record FlightPriceResponse(
    Long id,
    Long flightId,
    FlightClass flightClass,
    BigDecimal price
) {
    
}
