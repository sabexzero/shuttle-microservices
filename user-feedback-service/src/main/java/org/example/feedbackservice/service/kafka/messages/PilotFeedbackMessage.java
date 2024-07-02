package org.example.feedbackservice.service.kafka.messages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @pilotId - The ID of the pilot who left a review about the user
 * @userRate - The rating given by the pilot to the user
 * @userId - The ID of the user that the user rated
 *
 * @comment - A more detailed description of the reviews (optional)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PilotFeedbackMessage implements Serializable {
    private Integer userRate;
    private Long userId;
}
