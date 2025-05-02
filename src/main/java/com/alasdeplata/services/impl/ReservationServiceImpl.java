package com.alasdeplata.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.reservation.ReservationRequest;
import com.alasdeplata.dto.reservation.ReservationResponse;
import com.alasdeplata.mapper.ReservationMapper;
import com.alasdeplata.models.Reservation;
import com.alasdeplata.repository.FlightRepository;
import com.alasdeplata.repository.ReservationRepository;
import com.alasdeplata.repository.UserRepository;
import com.alasdeplata.services.ReservationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    @Override
    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<ReservationResponse> getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toResponse);
    }

    @Override
    public ReservationResponse createReservation(ReservationRequest reservation) {
        Reservation entity = reservationMapper.toEntity(reservation);

        if (reservation.userId() != null) {
            entity.setUser(userRepository.findById(reservation.userId())
                    .orElseThrow(() -> new RuntimeException("User not found")));
        }

        if (reservation.flightId() != null) {
            entity.setFlight(flightRepository.findById(reservation.flightId())
                    .orElseThrow(() -> new RuntimeException("Flight not found")));
        }

        Reservation saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public ReservationResponse updateReservation(Long id, ReservationRequest reservation) {
        Reservation entity = reservationMapper.toEntity(reservation);
        entity.setId(id);
        Reservation saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

}
