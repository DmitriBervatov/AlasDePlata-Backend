package com.alasdeplata.services;

import java.util.List;
import java.util.Optional;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;

public interface FlightService {
    Optional<FlightResponse> getFlightById(Long id);

    List<FlightResponse> getAllFlights();

    FlightResponse createFlight(FlightRequest flightRequest);

    FlightResponse updateFlight(Long id, FlightUpdateRequest flightRequest);

    void deleteFlight(Long id);

}
