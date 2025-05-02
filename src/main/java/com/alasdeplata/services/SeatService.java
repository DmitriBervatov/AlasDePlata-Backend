package com.alasdeplata.services;

import java.util.List;
import java.util.Optional;

import com.alasdeplata.dto.seat.SeatRequest;
import com.alasdeplata.dto.seat.SeatResponse;
import com.alasdeplata.dto.seat.SeatUpdateRequest;

public interface SeatService {
    List<SeatResponse> getAllSeats();

    Optional<SeatResponse> getSeatById(Long id);

    SeatResponse createSeat(SeatRequest item);

    SeatResponse updateSeat(Long id, SeatUpdateRequest item);

    void deleteSeat(Long id);
}
