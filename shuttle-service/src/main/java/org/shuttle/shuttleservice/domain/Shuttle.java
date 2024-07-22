package org.shuttle.shuttleservice.domain;

import org.shuttle.classes.Shuttle.ShuttleClass;
import org.shuttle.classes.planet.Planet;

public class Shuttle {
    private Long id;

    private ShuttleClass shuttleClass;
    private Planet currentPlanet;

    private Integer currentStationNumber;
}
