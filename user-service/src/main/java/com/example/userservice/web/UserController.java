package com.example.userservice.web;

import com.example.userservice.service.kafka.KafkaPublisher;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final KafkaPublisher kafkaPublisher;
    private final NewTopic newTopic2;

    @PostMapping
    public ResponseEntity<?> doSomething(
            @RequestBody String message
    ){
        kafkaPublisher.publish(message, newTopic2);
        return ResponseEntity.ok().build();
    }
}
