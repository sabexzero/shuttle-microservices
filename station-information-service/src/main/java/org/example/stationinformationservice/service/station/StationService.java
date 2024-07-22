package org.example.stationinformationservice.service.station;

import org.example.stationinformationservice.domain.Station;
import org.shuttle.classes.planet.Planet;

import java.util.List;

public interface StationService {
    List<Station> find(String planet);
    Station find(String planet, Integer number);
    Station find(Long id);

    //Station create();
    //Station update();
    //void delete();
}
