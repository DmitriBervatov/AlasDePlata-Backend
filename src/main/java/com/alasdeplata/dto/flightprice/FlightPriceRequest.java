package com.alasdeplata.dto.flightprice;

public record FlightPriceRequest(
        Long flightId,
        String flightClass,
        Double price) {

}
