package com.alasdeplata.services;

import java.util.List;
import java.util.Optional;

import com.alasdeplata.dto.destination.DestinationRequest;
import com.alasdeplata.dto.destination.DestinationResponse;
import com.alasdeplata.dto.destination.DestinationUpdateRequest;

public interface DestinationService {
    List<DestinationResponse> getAllDestinations();

    Optional<DestinationResponse> getDestinationById(Long id);

    DestinationResponse createDestination(DestinationRequest destinationRequest);

    DestinationResponse updateDestination(Long id, DestinationUpdateRequest destinationRequest);

    void deleteDestination(Long id);
}
