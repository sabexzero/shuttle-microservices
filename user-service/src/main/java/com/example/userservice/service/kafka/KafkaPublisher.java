package com.example.userservice.service.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
public class KafkaPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public void publish(String message, NewTopic topic){
        kafkaTemplate.send(topic.name(), message);
    }
}
