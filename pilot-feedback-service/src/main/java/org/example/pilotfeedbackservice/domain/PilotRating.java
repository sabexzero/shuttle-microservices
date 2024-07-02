package org.example.pilotfeedbackservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The rating works as follows, the user or the pilot puts a rating for the trip from 1-5.
 *
 * If the score is 1-2, then the rating of the person who was given this score
        will decrease by this value.
 * If the score is 3, then the rating of the person will not change in any way.
 * If the score is from 4-5, then the rating will increase by 1-2, respectively.
 *
 * The rating has no restrictions and can drop below zero or increase indefinitely.
 *
 * Everyone starts with a 500 rating
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PilotRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pilotId;
    private Integer rating;
}
