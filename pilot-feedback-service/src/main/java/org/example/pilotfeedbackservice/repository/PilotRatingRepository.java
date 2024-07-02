package org.example.pilotfeedbackservice.repository;

import org.example.pilotfeedbackservice.domain.PilotRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PilotRatingRepository extends JpaRepository<PilotRating, Long> {
    Optional<PilotRating> findByPilotId(Long pilotId);
}
