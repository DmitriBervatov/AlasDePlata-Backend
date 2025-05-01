package com.alasdeplata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alasdeplata.models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
