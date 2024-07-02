package org.example.pilotfeedbackservice.web.controllers;

import lombok.RequiredArgsConstructor;
import org.example.pilotfeedbackservice.service.pilot.PilotRatingService;
import org.example.pilotfeedbackservice.web.requests.PilotFeedbackRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot-feedbacks/")
@RequiredArgsConstructor
public class PilotFeedbackController {
    private final PilotRatingService pilotRatingService;

    @PostMapping
    public ResponseEntity<?> handlePilotFeedbackRequest(
            @RequestBody
            PilotFeedbackRequest request
    ){
        try{
            pilotRatingService.handlePilotFeedbackRequest(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(
                    exception.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @GetMapping
    public ResponseEntity<?> getPilotRating(
            @RequestParam Long pilotId
    ){
        try{
            return new ResponseEntity<>(
                    pilotRatingService.getPilotRating(pilotId),
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
