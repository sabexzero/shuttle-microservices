package org.shuttle.pilotpersonaldataservice.service.requests;

import org.shuttle.pilotpersonaldataservice.domain.RegisterPilotRequest;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;

public interface UpdatePilotPersonalDataRequestService {
    void saveUpdatePilotPersonalDataRequest(
            RegisterPilotRequest registerPilotRequest
    );
    void updateUpdatePilotPersonalDataRequest(
            String id,
            RequestStatus newStatus
    );

}
