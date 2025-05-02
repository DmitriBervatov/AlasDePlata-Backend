
package com.alasdeplata.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdeplata.dto.passenger.PassengerRequest;
import com.alasdeplata.dto.passenger.PassengerResponse;
import com.alasdeplata.dto.passenger.PassengerUpdateRequest;
import com.alasdeplata.mapper.PassengerMapper;
import com.alasdeplata.models.Passenger;
import com.alasdeplata.repository.PassengerRepository;
import com.alasdeplata.services.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public List<PassengerResponse> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerResponse getPassengerById(Long id) {
        return passengerRepository.findById(id)
        .map(passengerMapper::toResponse).orElse(null);
    }

    @Override
    public PassengerResponse createPassenger(PassengerRequest passenger) {
        Passenger entity = passengerMapper.toEntity(passenger);
        Passenger saved = passengerRepository.save(entity);
        return passengerMapper.toResponse(saved);
    }

    @Override
    public PassengerResponse updatePassenger(Long id, PassengerUpdateRequest passenger) {
        Passenger entity = passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("Passenger not found"));
        passengerMapper.updatePassengerFromDto(passenger, entity);
        Passenger updated = passengerRepository.save(entity);
        return passengerMapper.toResponse(updated);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

}