package org.shuttle.shuttleservice.service;

import org.shuttle.classes.planet.Planet;
import org.shuttle.shuttleservice.domain.Shuttle;

import java.util.List;

public interface ShuttleService {
    Shuttle findById(Long id);

    List<Shuttle> findByStation(String planetName, Integer stationNumber);

    List<Shuttle> findByPlanet(String planetName);
}
