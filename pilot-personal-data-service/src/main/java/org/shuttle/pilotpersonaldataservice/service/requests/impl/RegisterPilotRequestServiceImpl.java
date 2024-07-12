package org.shuttle.pilotpersonaldataservice.service.requests.impl;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.shuttle.kafka.pilot.personaldata.PilotPersonalDataChangeMessage;
import org.shuttle.pilotpersonaldataservice.domain.RegisterPilotRequest;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;
import org.shuttle.pilotpersonaldataservice.domain.status.Status;
import org.shuttle.pilotpersonaldataservice.repository.RegisterPilotRequestRepository;
import org.shuttle.pilotpersonaldataservice.service.kafka.KafkaPublisher;
import org.shuttle.pilotpersonaldataservice.service.requests.RegisterPilotRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterPilotRequestServiceImpl implements RegisterPilotRequestService {
    private final RegisterPilotRequestRepository repository;

    private final KafkaPublisher kafkaPublisher;

    @Override
    public void saveRegisterPilotRequest(RegisterPilotRequest registerPilotRequest) {
        repository.save(registerPilotRequest);
    }

    @Override
    public void updateRegisterPilotStatusRequest(
            String id,
            RequestStatus newStatus
    ) {
        RegisterPilotRequest registerPilotRequest = repository.findById(id).orElse(null);

        if (registerPilotRequest == null) {
            throw new NotFoundException("The request was not found");
        }

        registerPilotRequest = registerPilotRequest.updateStatus(
                newStatus
        );

        if (newStatus.getStatus().equals(Status.ALLOWED)){
            PilotPersonalDataChangeMessage message =
                    PilotPersonalDataChangeMessage.builder()
                            .dateTime(LocalDateTime.now())
                            .newpilotPersonalData(
                                    registerPilotRequest.getPilotPersonalData()
                            )
                            .build();
            kafkaPublisher.publish(message, "pilot-personal-data-change-topic");
        }

        repository.save(registerPilotRequest);

    }
}
