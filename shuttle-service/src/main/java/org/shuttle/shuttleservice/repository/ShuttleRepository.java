package org.shuttle.shuttleservice.repository;

import org.shuttle.classes.planet.Planet;
import org.shuttle.shuttleservice.domain.Shuttle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShuttleRepository extends JpaRepository<Shuttle, Long> {
    List<Shuttle> findByCurrentPlanet(Planet planet);
    List<Shuttle> findByCurrentPlanetAndCurrentStationNumber(Planet planet, Integer stationNumber);
}
