package org.example.feedbackservice.repository;

import org.example.feedbackservice.domain.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
    Optional<UserRating> findByUserId(Long userId);
}
