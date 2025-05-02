
package com.alasdeplata.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdeplata.dto.passenger.PassengerRequest;
import com.alasdeplata.dto.passenger.PassengerResponse;
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
    public PassengerResponse updatePassenger(Long id, PassengerRequest passenger) {
        return passengerRepository.findById(id)
                .map(existing -> {
                    Passenger updated = passengerMapper.toEntity(passenger);
                    updated.setId(id);
                    Passenger saved = passengerRepository.save(updated);
                    return passengerMapper.toResponse(saved);
                })
                .orElse(null);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

}