package org.example.pilotrankservice.service;

import org.shuttle.kafka.pilot.rank.PilotFinishedTripMessage;

public interface PilotExperienceService {
    void handleTripFinish(PilotFinishedTripMessage message);
}
