package com.alasdeplata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alasdeplata.models.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
