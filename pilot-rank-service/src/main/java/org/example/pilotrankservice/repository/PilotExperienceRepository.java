package org.example.pilotrankservice.repository;

import org.example.pilotrankservice.domain.PilotExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PilotExperienceRepository extends JpaRepository<PilotExperience, Long> {
    Optional<PilotExperience> findPilotExperienceByPilotId(Long pilotId);
}
