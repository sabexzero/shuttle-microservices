package org.example.pilotfeedbackservice.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumersTopics {
    @Bean
    public NewTopic pilotRatingChangerTopic(){
        return new NewTopic("pilot-rating-changer-topic", 1, (short) 1);
    }
}
