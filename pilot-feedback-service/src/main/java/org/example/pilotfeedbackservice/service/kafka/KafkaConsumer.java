package org.example.pilotfeedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pilotfeedbackservice.service.kafka.messages.PilotFeedbackMessage;
import org.example.pilotfeedbackservice.service.kafka.messages.UserFeedbackMessage;
import org.example.pilotfeedbackservice.service.pilot.PilotRatingService;
import org.example.pilotfeedbackservice.utils.json.JsonUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final PilotRatingService pilotRatingService;
    private final List<String> topics = List.of(
            "user-rating-changer-topic",
            "pilot-rating-create-topic"
    );

    @KafkaListener(
            topics = {
                    "user-rating-changer-topic",
                    "pilot-rating-create-topic"
            },
            groupId = "myGroup")
    public void listen(String message) {
        try {
            UserFeedbackMessage feedbackMessage = JsonUtils.readJson(
                    message,
                    UserFeedbackMessage.class
            );
            pilotRatingService.handleUserFeedbackMessage(feedbackMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
