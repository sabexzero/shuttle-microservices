package org.example.pilotfeedbackservice.service.pilot;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.pilotfeedbackservice.web.requests.PilotFeedbackRequest;
import org.shuttle.messages.UserFeedbackMessage;

public interface PilotRatingService {
    void handlePilotFeedbackRequest(PilotFeedbackRequest request) throws JsonProcessingException;
    void handleUserFeedbackMessage(UserFeedbackMessage message);
    //void initPilotRating();

    int getPilotRating(Long pilotId);
}
