package org.shuttle.pilotpersonaldataservice.service.kafka;

import lombok.AllArgsConstructor;
import org.shuttle.kafka.pilot.personaldata.PilotPersonalDataChangeMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaPublisher {
    private final KafkaTemplate<String, PilotPersonalDataChangeMessage> kafkaTemplate;

    public void publish(PilotPersonalDataChangeMessage message, String topic) {
        kafkaTemplate.send(topic, message);
    }
}
