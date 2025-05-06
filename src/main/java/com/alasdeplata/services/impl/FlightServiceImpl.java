package com.alasdeplata.services.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.flight.FlightDetailsResponse;
import com.alasdeplata.dto.flight.FlightRequest;
import com.alasdeplata.dto.flight.FlightResponse;
import com.alasdeplata.dto.flight.FlightUpdateRequest;
import com.alasdeplata.enums.FlightClass;
import com.alasdeplata.mapper.FlightMapper;
import com.alasdeplata.models.Flight;
import com.alasdeplata.repository.AirplaneRepository;
import com.alasdeplata.repository.DestinationRepository;
import com.alasdeplata.repository.FlightPriceRepository;
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
        private final FlightPriceRepository flightPriceRepository;

        @Override
        public Optional<FlightResponse> getFlightById(Long id) {
                return flightRepository.findById(id).map(flightMapper::toResponse);
        }

        @Override
        public List<FlightResponse> getAllFlights() {
                return flightRepository.findAll().stream().map(flightMapper::toResponse).toList();
        }

        @Override
        public List<FlightDetailsResponse> getAllFlightDetails() {
                return flightRepository.findAll().stream()
                                .map(flight -> {
                                        FlightDetailsResponse details = flightMapper.toDetailsResponse(flight);
                                        BigDecimal farePrice = flightPriceRepository
                                                        .findByFlightIdAndFlightClass(flight.getId(),
                                                                        FlightClass.ECONOMY)
                                                        .stream()
                                                        .map(price -> price.getPrice())
                                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                                        Duration duration = Duration.between(flight.getDepartureTime(),
                                                        flight.getArrivalTime());
                                        long hours = duration.toHours();
                                        long minutes = duration.toMinutesPart();

                                        String durationStr = String.format("%dh %02dm", hours, minutes);

                                        return new FlightDetailsResponse(
                                                        details.id(),
                                                        details.flightNumber(),
                                                        details.airline(),
                                                        details.origin(),
                                                        details.airportCodeOrigin(),
                                                        details.destination(),
                                                        details.airportCodeDestination(),
                                                        details.departureTime(),
                                                        details.arrivalTime(),
                                                        farePrice.doubleValue(),
                                                        durationStr);
                                })
                                .toList();
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

                Flight savedFlight = flightRepository.save(flight);

                return flightMapper.toResponse(savedFlight);
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

        @Override
        public List<FlightDetailsResponse> searchFlightDetails(
                        String origin,
                        String destination,
                        String departureDate,
                        String travelClass) {
                FlightClass flightClass = FlightClass.valueOf(travelClass.toUpperCase());
                return flightRepository.findAll().stream()
                                .filter(flight -> flight.getOrigin().getCity().equalsIgnoreCase(origin)
                                                && flight.getDestination().getCity().equalsIgnoreCase(destination)
                                                && flight.getDepartureTime().toLocalDate()
                                                                .toString()
                                                                .equals(departureDate))
                                .map(flight -> {
                                        FlightDetailsResponse details = flightMapper.toDetailsResponse(flight);
                                        BigDecimal farePrice = flightPriceRepository
                                                        .findByFlightIdAndFlightClass(flight.getId(),
                                                                        flightClass)
                                                        .stream()
                                                        .map(price -> price.getPrice())
                                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                                        Duration duration = Duration.between(flight.getDepartureTime(),
                                                        flight.getArrivalTime());
                                        long hours = duration.toHours();
                                        long minutes = duration.toMinutesPart();

                                        String durationStr = String.format("%dh %02dm", hours, minutes);

                                        return new FlightDetailsResponse(
                                                        details.id(),
                                                        details.flightNumber(),
                                                        details.airline(),
                                                        details.origin(),
                                                        details.airportCodeOrigin(),
                                                        details.destination(),
                                                        details.airportCodeDestination(),
                                                        details.departureTime(),
                                                        details.arrivalTime(),
                                                        farePrice.doubleValue(),
                                                        durationStr);
                                })
                                .toList();
        }

}
