package org.example.feedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.feedbackservice.service.kafka.messages.PilotFeedbackMessage;
import org.example.feedbackservice.service.user.UserRatingService;
import org.example.feedbackservice.utils.json.JsonUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final UserRatingService userRatingService;

    @KafkaListener(topics = "user-rating-changer-topic", groupId = "myGroup")
    public void listen(String message) {
        try {
            PilotFeedbackMessage feedbackMessage = JsonUtils.readJson(
                    message,
                    PilotFeedbackMessage.class
            );
            userRatingService.handlePilotFeedbackMessage(feedbackMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
