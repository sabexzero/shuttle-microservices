package org.example.stationinformationservice.service.station.impl;

import lombok.RequiredArgsConstructor;
import org.example.stationinformationservice.domain.Station;
import org.example.stationinformationservice.repository.StationRepository;
import org.example.stationinformationservice.service.station.StationService;
import org.shuttle.classes.planet.Planet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    @Override
    public List<Station> find(String planet) {
        return stationRepository.findByPlanet(
                Planet.valueOf(planet.trim().toUpperCase())
        );
    }

    @Override
    public Station find(String planet, Integer number) {
        return stationRepository.findByPlanetAndNumber(
                Planet.valueOf(planet.trim().toUpperCase()),
                number
        );
    }

    @Override
    public Station find(Long id) {
        return stationRepository.findById(id)
                .orElse(null);
    }
}
