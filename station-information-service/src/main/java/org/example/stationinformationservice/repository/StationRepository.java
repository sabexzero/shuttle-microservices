package org.example.stationinformationservice.repository;

import org.example.stationinformationservice.domain.Station;
import org.shuttle.classes.planet.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    List<Station> findByPlanet(Planet planet);
    Station findByPlanetAndNumber(Planet planet, int number);
}
