package com.example.userservice.service.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    
    @KafkaListener(topics = "testKafka", groupId = "myGroup")
    public void listen(String message) {
        log.info(message);
    }
}
