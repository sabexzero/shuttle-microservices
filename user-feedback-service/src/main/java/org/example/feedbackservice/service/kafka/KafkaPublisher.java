package org.example.feedbackservice.service.kafka;

import lombok.RequiredArgsConstructor;
import org.shuttle.kafka.feedback.UserFeedbackMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaPublisher {
    private final KafkaTemplate<String, UserFeedbackMessage> userFeedbackKafkaTemplate;

    public void publish(UserFeedbackMessage message, String topic){
        userFeedbackKafkaTemplate.send(topic, message);
    }
}
