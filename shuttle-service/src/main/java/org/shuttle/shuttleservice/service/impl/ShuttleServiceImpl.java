package org.shuttle.shuttleservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.shuttle.classes.planet.Planet;
import org.shuttle.shuttleservice.domain.Shuttle;
import org.shuttle.shuttleservice.repository.ShuttleRepository;
import org.shuttle.shuttleservice.service.ShuttleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShuttleServiceImpl implements ShuttleService {
    private final ShuttleRepository shuttleRepository;

    @Override
    public Shuttle findById(Long id) {
        return shuttleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Shuttle> findByStation(String planetName, Integer stationNumber) {
        return shuttleRepository.findByCurrentPlanetAndCurrentStationNumber(
                Planet.valueOf(planetName.trim().toUpperCase()),
                stationNumber
        );
    }

    @Override
    public List<Shuttle> findByPlanet(String planetName) {
        return shuttleRepository.findByCurrentPlanet(
                Planet.valueOf(planetName.trim().toUpperCase())
        );
    }
}
