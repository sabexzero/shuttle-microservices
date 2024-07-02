package org.example.feedbackservice.service.user.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.example.feedbackservice.domain.UserRating;
import org.example.feedbackservice.service.kafka.KafkaPublisher;
import org.example.feedbackservice.service.kafka.messages.PilotFeedbackMessage;
import org.example.feedbackservice.service.kafka.messages.UserFeedbackMessage;
import org.example.feedbackservice.utils.json.JsonUtils;
import org.example.feedbackservice.web.requests.UserFeedbackRequest;
import org.example.feedbackservice.repository.UserFeedbackRequestRepository;
import org.example.feedbackservice.repository.UserRatingRepository;
import org.example.feedbackservice.service.user.UserRatingService;
import org.example.feedbackservice.utils.RatingUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRatingServiceImpl implements UserRatingService {
    private final UserRatingRepository ratingRepository;
    private final UserFeedbackRequestRepository feedbackRequestRepository;

    private final KafkaPublisher kafkaPublisher;
    private final NewTopic pilotFeedbackTopic;

    @Override
    public void handleUserFeedbackRequest(UserFeedbackRequest request)
            throws JsonProcessingException {
        int ratingChange = RatingUtils.getRatingChange(request.getPilotRate());
        kafkaPublisher.publish(
                JsonUtils.writeJson(
                        UserFeedbackMessage.builder()
                                .pilotId(request.getPilotId())
                                .pilotRate(ratingChange)
                                .build()
                ),
                pilotFeedbackTopic
        );
        feedbackRequestRepository.save(request);
    }

    @Override
    public void handlePilotFeedbackMessage(PilotFeedbackMessage message) {
        UserRating toChange = ratingRepository.findById(message.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "The user whose rating needed to be changed was not found")
                );
        ratingRepository.save(
                UserRating.builder()
                        .id(toChange.getId())
                        .rating(toChange.getRating() + message.getUserRate())
                        .userId(toChange.getUserId())
                        .build()
        );
    }

    @Override
    public int getUserRating(Long userId) {
            return ratingRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "The user whose rating needed to be obtained was not found"
                ))
                .getRating();
    }
}
