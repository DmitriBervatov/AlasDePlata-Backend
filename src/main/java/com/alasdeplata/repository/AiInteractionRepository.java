package com.alasdeplata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alasdeplata.models.AiInteraction;

@Repository
public interface AiInteractionRepository extends JpaRepository<AiInteraction, Long> {
}