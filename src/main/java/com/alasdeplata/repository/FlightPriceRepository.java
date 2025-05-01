package com.alasdeplata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alasdeplata.models.FlightPrice;

@Repository
public interface FlightPriceRepository extends JpaRepository<FlightPrice, Long> {

}
