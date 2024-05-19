package com.example.notificationservice;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfiguration {
    
    @Bean
    public NewTopic newTopic(){
        return new NewTopic("testKafka", 1, (short) 1);
    }
}
