package org.example.pilotmanagementservice.repository;

import org.example.pilotmanagementservice.domain.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, Long> {
}
