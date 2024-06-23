package com.example.tripmanagementservice.service.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public void publish(String message, NewTopic topic){
        kafkaTemplate.send(topic.name(), message);
    }
}
