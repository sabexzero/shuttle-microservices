package org.shuttle.kafka.pilot.personaldata;

import lombok.Data;
import org.shuttle.classes.pilot.PilotPersonalData;

import java.time.LocalDateTime;

@Data
public class PilotPersonalDataChangeMessage {
    private PilotPersonalData pilotPersonalData;

    private LocalDateTime dateTime;
}
