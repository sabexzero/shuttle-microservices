package org.example.feedbackservice.repository;

import org.example.feedbackservice.web.requests.UserFeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedbackRequestRepository extends JpaRepository<UserFeedbackRequest, Long> { }
