package org.shuttle.shuttleservice.web;

import lombok.RequiredArgsConstructor;
import org.shuttle.shuttleservice.domain.Shuttle;
import org.shuttle.shuttleservice.service.ShuttleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shuttles")
public class ShuttleController {
    private final ShuttleService shuttleService;

    @GetMapping
    public ResponseEntity<?> getShuttles(
            @RequestParam(required = false)
            Long id,
            @RequestParam(required = false)
            String planet,
            @RequestParam(required = false)
            Integer stationNumber
    ) {
        try{
            Collection<Shuttle> result = new HashSet<>();
            if (id != null) {
                result.add(shuttleService.findById(id));
            } else if (planet != null && stationNumber != null) {
                result.addAll(shuttleService.findByStation(planet, stationNumber));
            } else if (planet != null) {
                result.addAll(shuttleService.findByPlanet(planet));
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
