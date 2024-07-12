package org.example.pilotmanagementservice.service;

import com.example.pilotservice.web.requests.RegisterPilotRequest;
import org.example.pilotmanagementservice.domain.Pilot;

public interface PilotService {
    Pilot register(RegisterPilotRequest request);
    Pilot handlePilotUpdateRequest()
}
