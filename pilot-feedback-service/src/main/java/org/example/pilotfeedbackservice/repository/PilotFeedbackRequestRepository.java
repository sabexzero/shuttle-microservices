package org.example.pilotfeedbackservice.repository;

import org.example.pilotfeedbackservice.web.requests.PilotFeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotFeedbackRequestRepository
        extends JpaRepository<PilotFeedbackRequest, Long> {
    List<PilotFeedbackRequest> findByPilotId(long pilotId);
}
