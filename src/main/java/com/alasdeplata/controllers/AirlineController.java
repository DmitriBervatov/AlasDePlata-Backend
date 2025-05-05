package com.alasdeplata.controllers;

import com.alasdeplata.dto.airline.AirlineRequest;
import com.alasdeplata.dto.airline.AirlineResponse;
import com.alasdeplata.dto.airline.AirlineUpdateRequest;
import com.alasdeplata.services.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public ResponseEntity<List<AirlineResponse>> getAll() {
        return ResponseEntity.ok(airlineService.getAllAirlines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineResponse> getAirlineById(@PathVariable Long id) {
        return ResponseEntity.ok(airlineService.getAirlineById(id));
    }

    @PostMapping
    public ResponseEntity<AirlineResponse> createAirline(@RequestBody AirlineRequest airlineRequest) {
        return ResponseEntity.ok(airlineService.createAirline(airlineRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineResponse> updateAirline(@PathVariable Long id, @RequestBody AirlineUpdateRequest airlineRequest) {
        return ResponseEntity.ok(airlineService.updateAirline(id, airlineRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAirline(@RequestParam Long id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }

}
