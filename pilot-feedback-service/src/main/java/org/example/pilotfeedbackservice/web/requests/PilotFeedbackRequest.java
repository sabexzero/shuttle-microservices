package org.example.pilotfeedbackservice.web.requests;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @pilotId - The ID of the pilot who left a review about the user
 * @userRate - The rating given by the pilot to the user
 * @userId - The ID of the user that the user rated
 *
 * @comment - A more detailed description of the reviews (optional)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PilotFeedbackRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pilotId;

    private Integer userRate;
    private Long userId;

    private Long tripId;

    private String comment;

}
