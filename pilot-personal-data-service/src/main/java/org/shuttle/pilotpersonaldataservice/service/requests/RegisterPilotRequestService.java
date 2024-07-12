package org.shuttle.pilotpersonaldataservice.service.requests;

import org.shuttle.pilotpersonaldataservice.domain.RegisterPilotRequest;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;

public interface RegisterPilotRequestService {
    void saveRegisterPilotRequest(
            RegisterPilotRequest registerPilotRequest
    );
    void updateRegisterPilotStatusRequest(
            String id,
            RequestStatus newStatus
    );

}
