package org.shuttle.pilotpersonaldataservice.domain.status;

import lombok.Getter;

@Getter
public class RequestStatus {
    private Status status;
    private String message;
}
