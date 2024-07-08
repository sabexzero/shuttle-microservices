package org.example.pilotfeedbackservice.service.pilot.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.example.pilotfeedbackservice.domain.PilotRating;
import org.example.pilotfeedbackservice.repository.PilotFeedbackRequestRepository;
import org.example.pilotfeedbackservice.repository.PilotRatingRepository;
import org.example.pilotfeedbackservice.service.kafka.KafkaPublisher;
import org.example.pilotfeedbackservice.service.pilot.PilotRatingService;
import org.example.pilotfeedbackservice.utils.RatingUtils;
import org.example.pilotfeedbackservice.web.requests.PilotFeedbackRequest;
import org.shuttle.messages.PilotFeedbackMessage;
import org.shuttle.messages.UserFeedbackMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PilotRatingServiceImpl implements PilotRatingService {
    private final PilotRatingRepository ratingRepository;
    private final PilotFeedbackRequestRepository feedbackRequestRepository;

    private final KafkaPublisher kafkaPublisher;
    private final NewTopic userRatingChangerTopic;

    @Override
    public void handlePilotFeedbackRequest(PilotFeedbackRequest request)
            throws JsonProcessingException {
        int ratingChange = RatingUtils.getRatingChange(request.getUserRate());
        kafkaPublisher.publish(
                PilotFeedbackMessage.builder()
                        .userId(request.getPilotId())
                        .userRate(ratingChange)
                        .build(),
                "user-rating-changer-topic"
        );
        feedbackRequestRepository.save(request);
    }

    @Override
    public void handleUserFeedbackMessage(UserFeedbackMessage message) {
        PilotRating toChange = ratingRepository.findById(message.getPilotId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "The user whose rating needed to be changed was not found")
                );
        ratingRepository.save(
                PilotRating.builder()
                        .id(toChange.getId())
                        .rating(toChange.getRating() + message.getPilotRate())
                        .pilotId(toChange.getPilotId())
                        .build()
        );
    }

    @Override
    public int getPilotRating(Long pilotId) {
        return ratingRepository.findByPilotId(pilotId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "The user whose rating needed to be obtained was not found"
                ))
                .getRating();
    }
}
