package org.example.pilotfeedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import org.shuttle.messages.PilotFeedbackMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaPublisher{
    private final KafkaTemplate<String, PilotFeedbackMessage> pilotFeedbackKafkaTemplate;

    public void publish(PilotFeedbackMessage message, String topic){
        pilotFeedbackKafkaTemplate.send(topic, message);
    }
}
