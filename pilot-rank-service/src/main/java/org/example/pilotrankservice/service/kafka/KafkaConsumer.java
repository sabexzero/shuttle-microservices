package org.example.pilotrankservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pilotrankservice.service.PilotExperienceService;
import org.shuttle.kafka.pilot.rank.PilotFinishedTripMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final PilotExperienceService pilotExperienceService;

    @KafkaListener(topics = "trip-finished-topic", groupId = "pilotGroup",
            containerFactory = "pilotFinishedTripKafkaListenerContainerFactory")
    public void listenUserRatingChangerTopic(PilotFinishedTripMessage message) {
        log.info("Received message through MessageConverterPilotListener [{}]", message);
        pilotExperienceService.handleTripFinish(message);
    }
}
