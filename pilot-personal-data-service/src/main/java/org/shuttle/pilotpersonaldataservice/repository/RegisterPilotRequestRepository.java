package org.shuttle.pilotpersonaldataservice.repository;

import org.shuttle.pilotpersonaldataservice.domain.RegisterPilotRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterPilotRequestRepository
        extends MongoRepository<RegisterPilotRequest, String> {
}
