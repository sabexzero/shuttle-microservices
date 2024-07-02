package org.example.feedbackservice.web.controllers;

import lombok.RequiredArgsConstructor;
import org.example.feedbackservice.service.user.UserRatingService;
import org.example.feedbackservice.web.requests.UserFeedbackRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-feedbacks")
@RequiredArgsConstructor
public class UserFeedbackController {
    private final UserRatingService userRatingService;

    @PostMapping
    public ResponseEntity<?> handlePilotFeedbackRequest(
            @RequestBody
            UserFeedbackRequest request
    ){
        try{
            userRatingService.handleUserFeedbackRequest(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(
                    exception.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @GetMapping
    public ResponseEntity<?> getUserRating(
            @RequestParam Long userId
    ){
        try{
            return new ResponseEntity<>(
                    userRatingService.getUserRating(userId),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            return new ResponseEntity<>(
                    exception.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }
}
