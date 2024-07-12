package org.shuttle.pilotpersonaldataservice.service.requests.impl;

import lombok.RequiredArgsConstructor;
import org.shuttle.pilotpersonaldataservice.domain.RegisterPilotRequest;
import org.shuttle.pilotpersonaldataservice.domain.status.RequestStatus;
import org.shuttle.pilotpersonaldataservice.repository.UpdatePilotPersonalDataRequestRepository;
import org.shuttle.pilotpersonaldataservice.service.requests.UpdatePilotPersonalDataRequestService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePilotPersonalDataRequestServiceImpl implements UpdatePilotPersonalDataRequestService {
    private final UpdatePilotPersonalDataRequestRepository repository;

    @Override
    public void saveUpdatePilotPersonalDataRequest(RegisterPilotRequest registerPilotRequest) {

    }

    @Override
    public void updateUpdatePilotPersonalDataRequest(String id, RequestStatus newStatus) {

    }
}
