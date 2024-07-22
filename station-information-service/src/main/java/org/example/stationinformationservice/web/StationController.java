package org.example.stationinformationservice.web;

import lombok.RequiredArgsConstructor;
import org.example.stationinformationservice.domain.Station;
import org.example.stationinformationservice.service.station.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;

    @GetMapping
    public ResponseEntity<?> getStations(
            @RequestParam(required = false)
            Long id,
            @RequestParam(required = false)
            String planet,
            @RequestParam(required = false)
            Integer stationNumber
    ) {
        try{
            Collection<Station> result = new HashSet<>();
            if (id != null) {
                result.add(stationService.find(id));
            } else if (planet != null && stationNumber != null) {
                result.addAll(stationService.find(planet));
            } else if (planet != null) {
                result.add(stationService.find(planet, stationNumber));
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
