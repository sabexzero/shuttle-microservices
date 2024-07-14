package org.example.pilotrankservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pilotrankservice.domain.PilotExperience;
import org.example.pilotrankservice.repository.PilotExperienceRepository;
import org.example.pilotrankservice.service.PilotExperienceService;
import org.example.pilotrankservice.service.kafka.KafkaPublisher;
import org.example.pilotrankservice.utils.ExperienceConstants;
import org.shuttle.kafka.pilot.rank.PilotFinishedTripMessage;
import org.shuttle.kafka.pilot.rank.PilotRankChangeMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PilotExperienceServiceImpl implements PilotExperienceService {
    private PilotExperienceRepository pilotExperienceRepository;
    private KafkaPublisher kafkaPublisher;

    @Override
    public void handleTripFinish(PilotFinishedTripMessage message) {
        PilotExperience pilotExperience = pilotExperienceRepository
                .findPilotExperienceByPilotId(message.getPilotId())
                .orElseThrow(() -> new RuntimeException("PilotExperience not found"));

        int rankDifference = message.getPilotRankLevel() - message.getTripDifficultyLevel();

        int earnedExperience = ExperienceConstants.DEFAULT_EXPERIENCE_CHANGE_AMOUNT
                .getXp() - rankDifference;

        int newExperience = pilotExperience.getExperience() + earnedExperience;

        if(newExperience >= ExperienceConstants.EXPERIENCE_LEVEL_TO_INCREASE_RANK.getXp()) {
            //TODO IMPLEMENT PRODUCER
        }

        pilotExperienceRepository.save(
                pilotExperience.updateExperience(
                        newExperience
                )
        );
    }
}
