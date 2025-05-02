package com.alasdeplata.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.reservationpassenger.ReservationPassengerRequest;
import com.alasdeplata.dto.reservationpassenger.ReservationPassengerResponse;
import com.alasdeplata.dto.reservationpassenger.ReservationPassengerUpdateRequest;
import com.alasdeplata.mapper.ReservationPassengerMapper;
import com.alasdeplata.models.ReservationPassenger;
import com.alasdeplata.repository.ReservationPassengerRepository;
import com.alasdeplata.services.ReservationPassengerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationPassengerServiceImpl implements ReservationPassengerService {

    private final ReservationPassengerRepository reservationPassengerRepository;
    private final ReservationPassengerMapper reservationPassengerMapper;

    @Override
    public List<ReservationPassengerResponse> getAllReservationPassengers() {
        return reservationPassengerRepository.findAll().stream()
                .map(reservationPassengerMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<ReservationPassengerResponse> getReservationPassengerById(Long id) {
        return reservationPassengerRepository.findById(id)
                .map(reservationPassengerMapper::toResponse);
    }

    @Override
    public ReservationPassengerResponse createReservationPassenger(ReservationPassengerRequest request) {
        ReservationPassenger reservationPassenger = reservationPassengerMapper.toEntity(request);
        ReservationPassenger savedReservationPassenger = reservationPassengerRepository.save(reservationPassenger);
        return reservationPassengerMapper.toResponse(savedReservationPassenger);
    }

    @Override
    public ReservationPassengerResponse updateReservationPassenger(Long id, ReservationPassengerUpdateRequest request) {
        ReservationPassenger reservationPassenger = reservationPassengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ReservationPassenger not found"));

        reservationPassengerMapper.updateReservationPassengerFromDto(request, reservationPassenger);

        ReservationPassenger updatedReservationPassenger = reservationPassengerRepository.save(reservationPassenger);
        return reservationPassengerMapper.toResponse(updatedReservationPassenger);
    }

    @Override
    public void deleteReservationPassenger(Long id) {
        reservationPassengerRepository.deleteById(id);
    }

}
