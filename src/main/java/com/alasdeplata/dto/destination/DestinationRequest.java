package com.alasdeplata.dto.destination;

import jakarta.validation.constraints.NotBlank;

public record DestinationRequest(
        @NotBlank String city,
        @NotBlank String country,
        @NotBlank String airportCode) {

}
