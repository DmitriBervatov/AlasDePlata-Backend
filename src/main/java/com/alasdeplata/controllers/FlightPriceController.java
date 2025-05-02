package com.alasdeplata.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alasdeplata.dto.flightprice.FlightPriceRequest;
import com.alasdeplata.dto.flightprice.FlightPriceResponse;
import com.alasdeplata.dto.flightprice.FlightPriceUpdateRequest;
import com.alasdeplata.services.FlightPriceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/flight-prices")
@RequiredArgsConstructor
public class FlightPriceController {

    private final FlightPriceService flightPriceService;

    @GetMapping
    public ResponseEntity<List<FlightPriceResponse>> getAllFlightPrices() {
        return ResponseEntity.ok(flightPriceService.getAllFlightPrices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightPriceResponse> getFlightPriceById(@PathVariable Long id) {
        return ResponseEntity.ok(flightPriceService.getFlightPriceById(id));
    }

    @PostMapping
    public ResponseEntity<FlightPriceResponse> createFlightPrice(@RequestBody @Valid FlightPriceRequest flightPriceRequest) {
        return ResponseEntity.ok(flightPriceService.createFlightPrice(flightPriceRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightPriceResponse> updateFlightPrice(@PathVariable Long id,
            @RequestBody @Valid FlightPriceUpdateRequest flightPriceUpdateRequest) {
        return ResponseEntity.ok(flightPriceService.updateFlightPrice(id, flightPriceUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightPrice(@PathVariable Long id) {
        flightPriceService.deleteFlightPrice(id);
        return ResponseEntity.noContent().build();
    }

}
