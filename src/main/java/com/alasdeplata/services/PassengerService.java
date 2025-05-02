package com.alasdeplata.services;

import java.util.List;

import com.alasdeplata.dto.passenger.PassengerRequest;
import com.alasdeplata.dto.passenger.PassengerResponse;

public interface PassengerService {

    List<PassengerResponse> getAllPassengers();

    PassengerResponse getPassengerById(Long id);

    PassengerResponse createPassenger(PassengerRequest passenger);

    PassengerResponse updatePassenger(Long id, PassengerRequest passenger);

    void deletePassenger(Long id);
}
