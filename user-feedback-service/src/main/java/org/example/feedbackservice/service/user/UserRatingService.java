package org.example.feedbackservice.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.feedbackservice.service.kafka.messages.PilotFeedbackMessage;
import org.example.feedbackservice.web.requests.UserFeedbackRequest;

public interface UserRatingService {
    void handleUserFeedbackRequest(UserFeedbackRequest request) throws JsonProcessingException;
    void handlePilotFeedbackMessage(PilotFeedbackMessage message);

    int getUserRating(Long userId);
}
