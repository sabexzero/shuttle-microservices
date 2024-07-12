package org.shuttle.pilotpersonaldataservice.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.shuttle.classes.pilot.PilotPersonalData;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "update-pilot-personal-data-requests")
public class UpdatePilotPersonalDataRequest {
    @Id
    private Long id;

    private String pilotId;
    private String reason;

    private PilotPersonalData newPersonalData;

    private LocalDateTime dateTime;

    private RequestStatus status;

    public UpdatePilotPersonalDataRequest updateStatus(RequestStatus newStatus){
        return UpdatePilotPersonalDataRequest.builder()
                .id(id)
                .newPersonalData(newPersonalData)
                .dateTime(dateTime)
                .status(newStatus)
                .build();
    }
}
