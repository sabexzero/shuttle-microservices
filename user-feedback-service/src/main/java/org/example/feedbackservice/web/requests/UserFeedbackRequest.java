package org.example.feedbackservice.web.requests;

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
 * @userId - The ID of the user who left a review about the pilot
 * @pilotRate - The rating given by the user to the pilot
 * @pilotId - The ID of the pilot that the user rated
 *
 * @comment - A more detailed description of the reviews (optional)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFeedbackRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long tripId;

    private Integer pilotRate;
    private Long pilotId;

    private String comment;

}
