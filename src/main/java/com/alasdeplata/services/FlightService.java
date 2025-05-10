package com.alasdeplata.services;

import java.util.List;
import java.util.Optional;

import com.alasdeplata.dto.flight.FlightDetailsResponse;
import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightRequestFilter;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;

public interface FlightService {
    Optional<FlightResponse> getFlightById(Long id);

    List<FlightResponse> getAllFlights();

    List<FlightDetailsResponse> getAllFlightDetails();
    
    FlightResponse createFlight(FlightRequest flightRequest);

    FlightResponse updateFlight(Long id, FlightUpdateRequest flightRequest);

    void deleteFlight(Long id);

    List<FlightDetailsResponse> searchFlightDetails(FlightRequestFilter flightRequestFilter);


}
