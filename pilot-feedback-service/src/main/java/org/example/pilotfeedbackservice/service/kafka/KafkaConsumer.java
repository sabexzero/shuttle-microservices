package org.example.pilotfeedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pilotfeedbackservice.service.pilot.PilotRatingService;
import org.shuttle.messages.UserFeedbackMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final PilotRatingService pilotRatingService;

        @KafkaListener(topics = "pilot-rating-changer-topic", groupId = "myGroup",
            containerFactory = "userFeedbackKafkaListenerContainerFactory")
    public void listenUserRatingChangerTopic(UserFeedbackMessage userFeedbackMessage) {
        log.info("Received message through MessageConverterPilotListener [{}]", userFeedbackMessage);
        pilotRatingService.handleUserFeedbackMessage(userFeedbackMessage);
    }
}
