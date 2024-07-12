package org.shuttle.classes.trip;

import org.shuttle.classes.pilot.PilotRank;

import java.time.LocalDate;

public class TripInfo {
    private String departurePlanet;
    private String arrivalPlanet;

    private LocalDate date;

    private TripDifficulty tripDifficulty;
    private PilotRank pilotRank;
}
