package org.shuttle.pilotpersonaldataservice.repository;

import org.shuttle.pilotpersonaldataservice.domain.UpdatePilotPersonalDataRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UpdatePilotPersonalDataRequestRepository
        extends MongoRepository<UpdatePilotPersonalDataRequest, String> {
}
