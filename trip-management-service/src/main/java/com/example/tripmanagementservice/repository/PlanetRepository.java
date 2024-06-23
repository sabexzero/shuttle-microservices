package com.example.tripmanagementservice.repository;

import com.example.tripmanagementservice.domain.Planet;

import java.util.List;

public interface PlanetRepository {
    List<Planet> findAll();
}
