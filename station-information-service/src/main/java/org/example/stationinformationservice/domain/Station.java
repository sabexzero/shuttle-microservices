package org.example.stationinformationservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.shuttle.classes.planet.Planet;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Enum with planets
    private Planet planet;

    // The quantitative number of the station on the planet
    private Integer number;

    private Integer shuttlePlaces;
    private Integer currentShuttles;
}
