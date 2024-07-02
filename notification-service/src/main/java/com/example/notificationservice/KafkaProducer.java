package com.example.notificationservice;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic newTopic;
    
    public void sendMessage(String message){
        kafkaTemplate.send(newTopic.name(), message);
    }
}
