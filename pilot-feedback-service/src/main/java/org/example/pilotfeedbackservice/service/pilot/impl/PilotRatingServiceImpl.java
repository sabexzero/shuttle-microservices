package org.example.pilotfeedbackservice.service.pilot.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.example.pilotfeedbackservice.domain.PilotRating;
import org.example.pilotfeedbackservice.repository.PilotFeedbackRequestRepository;
import org.example.pilotfeedbackservice.repository.PilotRatingRepository;
import org.example.pilotfeedbackservice.service.kafka.KafkaPublisher;
import org.example.pilotfeedbackservice.service.kafka.messages.PilotFeedbackMessage;
import org.example.pilotfeedbackservice.service.kafka.messages.UserFeedbackMessage;
import org.example.pilotfeedbackservice.service.pilot.PilotRatingService;
import org.example.pilotfeedbackservice.utils.RatingUtils;
import org.example.pilotfeedbackservice.utils.json.JsonUtils;
import org.example.pilotfeedbackservice.web.requests.PilotFeedbackRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PilotRatingServiceImpl implements PilotRatingService {
    private final PilotRatingRepository ratingRepository;
    private final PilotFeedbackRequestRepository feedbackRequestRepository;

    private final KafkaPublisher kafkaPublisher;
    private final NewTopic pilotFeedbackTopic;

    @Override
    public void handlePilotFeedbackRequest(PilotFeedbackRequest request)
            throws JsonProcessingException {
        int ratingChange = RatingUtils.getRatingChange(request.getUserRate());
        kafkaPublisher.publish(
                JsonUtils.writeJson(
                        PilotFeedbackMessage.builder()
                                .userId(request.getPilotId())
                                .userRate(ratingChange)
                                .build()
                ),
                pilotFeedbackTopic
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
