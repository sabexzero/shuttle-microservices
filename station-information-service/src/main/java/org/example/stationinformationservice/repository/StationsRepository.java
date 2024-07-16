package org.example.stationinformationservice.repository;

import org.example.stationinformationservice.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationsRepository extends JpaRepository<Station, Long> {
}
