package com.alasdeplata.dto.airplane;

public record AirplaneRequest(
        String model,
        Integer capacity,
        String registrationNumber) {

}
