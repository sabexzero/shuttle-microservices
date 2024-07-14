package org.example.pilotrankservice.service.kafka;

import lombok.RequiredArgsConstructor;
import org.shuttle.kafka.feedback.UserFeedbackMessage;
import org.shuttle.kafka.pilot.rank.PilotRankChangeMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaPublisher {
    private final KafkaTemplate<String, PilotRankChangeMessage> pilotRankChangeKafkaTemplate;

    public void publish(PilotRankChangeMessage message, String topic){
        pilotRankChangeKafkaTemplate.send(topic, message);
    }
}
