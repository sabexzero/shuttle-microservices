package com.example.notificationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final KafkaProducer kafkaProducer;
    
    @PostMapping("/send")
    public void sendData(@RequestBody String message){
        kafkaProducer.sendMessage(message);
    }
}
