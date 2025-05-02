package com.alasdeplata.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.mapper.FlightMapper;
import com.alasdeplata.models.Flight;
import com.alasdeplata.repository.AirplaneRepository;
import com.alasdeplata.repository.DestinatioRepository;
import com.alasdeplata.repository.FlightRepository;
import com.alasdeplata.services.FlightService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final AirplaneRepository airplaneRepository;
    private final DestinatioRepository destinatioRepository;

    @Override
    public FlightResponse getFlightById(Long id) {
        return flightRepository.findById(id).map(flightMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll().stream().map(flightMapper::toResponse).toList();
    }

    @Override
    public FlightResponse createFlight(FlightRequest flightRequest) {
        return flightMapper.toResponse(flightRepository.save(flightMapper.toEntity(flightRequest)));
    }

    @Override
    public FlightResponse updateFlight(Long id, FlightRequest flightRequest) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightNumber(flightRequest.flightNumber());
        flight.setDepartureTime(flightRequest.departureTime());
        flight.setArrivalTime(flightRequest.arrivalTime());

        flight.setAirplane(
                airplaneRepository.findById(flightRequest.airlineId())
                        .orElseThrow(() -> new RuntimeException("Airplane not found")));
        flight.setOrigin(destinatioRepository.findById(flightRequest.originId())
                .orElseThrow(() -> new RuntimeException("Origin not found")));
        flight.setDestination(destinatioRepository.findById(flightRequest.destinationId())
                .orElseThrow(() -> new RuntimeException("Destination not found")));

        flight.setStatus(flightRequest.status());
        return flightMapper.toResponse(flightRepository.save(flight));
    }

    @Override
    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flightRepository.delete(flight);
    }

}
