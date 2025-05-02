package com.alasdeplata.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;
import com.alasdeplata.mapper.FlightMapper;
import com.alasdeplata.models.Flight;
import com.alasdeplata.repository.AirplaneRepository;
import com.alasdeplata.repository.DestinationRepository;
import com.alasdeplata.repository.FlightRepository;
import com.alasdeplata.services.FlightService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

        private final FlightRepository flightRepository;
        private final FlightMapper flightMapper;
        private final AirplaneRepository airplaneRepository;
        private final DestinationRepository destinationRepository;

        @Override
        public Optional<FlightResponse> getFlightById(Long id) {
                return flightRepository.findById(id).map(flightMapper::toResponse);
        }

        @Override
        public List<FlightResponse> getAllFlights() {
                return flightRepository.findAll().stream().map(flightMapper::toResponse).toList();
        }

        @Override
        public FlightResponse createFlight(FlightRequest flightRequest) {

                Flight flight = flightMapper.toEntity(flightRequest);

                flight.setOrigin(destinationRepository.findById(flightRequest.originId())
                                .orElseThrow(() -> new RuntimeException("Origin not found")));
                flight.setDestination(destinationRepository.findById(flightRequest.destinationId())
                                .orElseThrow(() -> new RuntimeException("Destination not found")));
                flight.setAirplane(airplaneRepository.findById(flightRequest.airlineId())
                                .orElseThrow(() -> new RuntimeException("Airplane not found")));

                return flightMapper.toResponse(flightRepository.save(flight));
        }

        @Override
        public FlightResponse updateFlight(Long id, FlightUpdateRequest flightRequest) {
                Flight flight = flightRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Flight not found"));

                flightMapper.updateFlightFromDto(flightRequest, flight);

                if (flightRequest.airlineId() != null) {
                        flight.setAirplane(airplaneRepository.findById(flightRequest.airlineId())
                                        .orElseThrow(() -> new RuntimeException("Airplane not found")));
                }
                if (flightRequest.originId() != null) {
                        flight.setOrigin(destinationRepository.findById(flightRequest.originId())
                                        .orElseThrow(() -> new RuntimeException("Origin not found")));
                }
                if (flightRequest.destinationId() != null) {
                        flight.setDestination(destinationRepository.findById(flightRequest.destinationId())
                                        .orElseThrow(() -> new RuntimeException("Destination not found")));
                }

                return flightMapper.toResponse(flightRepository.save(flight));
        }

        @Override
        public void deleteFlight(Long id) {
                Flight flight = flightRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Flight not found"));
                flightRepository.delete(flight);
        }

}
