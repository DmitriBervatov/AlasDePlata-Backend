package com.alasdeplata.dto.destination;

public record DestinationResponse(
        Long id,
        String city,
        String country,
        String airportCode) {

}
