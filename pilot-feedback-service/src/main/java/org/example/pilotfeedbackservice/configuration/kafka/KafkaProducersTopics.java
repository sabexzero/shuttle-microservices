package org.example.pilotfeedbackservice.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

public class KafkaProducersTopics {
    @Bean
    public NewTopic userRatingChangerTopic(){
        return new NewTopic("user-rating-changer-topic", 1, (short) 1);
    }
}
