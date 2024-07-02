package org.example.pilotfeedbackservice.service.kafka.messages;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserFeedbackMessage implements Serializable {
    private Integer pilotRate;
    private Long pilotId;
}
