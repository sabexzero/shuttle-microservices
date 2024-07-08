package org.example.feedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.feedbackservice.service.user.UserRatingService;
import org.shuttle.messages.PilotFeedbackMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final UserRatingService userRatingService;

    @KafkaListener(topics = "user-rating-changer-topic", groupId = "myGroup2",
            containerFactory = "pilotFeedbackKafkaListenerContainerFactory")
    public void listenUserRatingChangerTopic(PilotFeedbackMessage pilotFeedbackMessage) {
        log.info("Received message through MessageConverterPilotListener [{}]", pilotFeedbackMessage);
        userRatingService.handlePilotFeedbackMessage(pilotFeedbackMessage);
    }
}
