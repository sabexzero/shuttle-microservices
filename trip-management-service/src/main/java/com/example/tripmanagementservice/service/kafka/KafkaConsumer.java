package com.example.tripmanagementservice.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final KafkaPublisher kafkaPublisher;
    private final NewTopic newTopic2;

    @KafkaListener(topics = "testKafka", groupId = "myGroup")
    public void listen(String message) {
        log.info(message);
        String newMessage = message + " hui";
        kafkaPublisher.publish(newMessage, newTopic2);
    }
}
