package org.shuttle.pilotpersonaldataservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.shuttle.classes.pilot.PilotPersonalData;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "register-pilot-requests")
public class RegisterPilotRequest {
    @Id
    private String id;

    private PilotPersonalData pilotPersonalData;

    private String phoneNumber;
    private String email;

    private Integer tripsAmount;

    private LocalDateTime dateTime;

    private RequestStatus status;

    public RegisterPilotRequest updateStatus(RequestStatus newStatus){
        return RegisterPilotRequest.builder()
                .id(id)
                .pilotPersonalData(pilotPersonalData)
                .phoneNumber(phoneNumber)
                .email(email)
                .tripsAmount(tripsAmount)
                .dateTime(dateTime)
                .status(newStatus)
                .build();
    }
}
