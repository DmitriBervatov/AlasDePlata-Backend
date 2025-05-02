package com.alasdeplata.services;

import java.util.List;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;

public interface FlightService {
    FlightResponse getFlightById(Long id);

    List<FlightResponse> getAllFlights();

    FlightResponse createFlight(FlightRequest flightRequest);

    FlightResponse updateFlight(Long id, FlightRequest flightRequest);

    void deleteFlight(Long id);

}
