package com.alasdeplata.dto.destination;

public record DestinationRequest(
        String city,
        String country,
        String airportCode) {

}
