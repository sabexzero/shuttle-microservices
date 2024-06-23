package com.example.tripmanagementservice.service;

import com.example.tripmanagementservice.domain.Planet;
import com.example.tripmanagementservice.repository.PlanetRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class PlanetPositionsCalculationService {
    private final PlanetRepository planetRepository; // Repository for accessing planet data
    
    private final Map<String, ArrayList<Double[]>> planetsOrbit; // Map to store orbit coordinates for each planet
    
    @PostConstruct
    private void calculateOrbitCoordinates() {
        int numPoints = 10000; // Number of points to calculate on each orbit
        
        List<Planet> planets = planetRepository.findAll(); // Retrieve all planets from the repository
        
        planets.forEach(planet -> { // Iterate over each planet
            ArrayList<Double[]> orbitCoordinates = new ArrayList<>(); // List to store orbit coordinates
            
            // Arrays to store intermediate values for calculation
            double[] theta = new double[numPoints];
            double[] r = new double[numPoints];
            double[] x = new double[numPoints];
            double[] y = new double[numPoints];
            
            for (int i = 0; i < numPoints; i++) { // Loop to calculate coordinates for each point on the orbit
                theta[i] = 2 * Math.PI * i / numPoints; // Calculate theta
                r[i] = planet.getSemiMajorAxis() *
                        (1 - planet.getEccentricity() * planet.getEccentricity()) /
                        (1 + planet.getEccentricity() * Math.cos(theta[i])); // Calculate radius
                x[i] = r[i] * Math.cos(theta[i]); // Calculate x-coordinate
                y[i] = r[i] * Math.sin(theta[i]); // Calculate y-coordinate
                orbitCoordinates.add(new Double[]{x[i], y[i]}); // Add coordinates to the list
            }
            
            planetsOrbit.put(planet.getName(), orbitCoordinates); // Store orbit coordinates for the planet
        });
    }
    
    // Method to calculate position of a planet at a given time
    public double[] calculatePlanetPosition(Planet planet, double t) {
        double M = 2 * Math.PI / planet.getOrbitalPeriod() * t; // Calculate mean anomaly
        double nu = getAnomaly(planet, M); // Calculate true anomaly
        double r = planet.getSemiMajorAxis() *
                (1 - planet.getEccentricity() * planet.getEccentricity()) /
                (1 + planet.getEccentricity() * Math.cos(nu)); // Calculate radius
        double x = r * Math.cos(nu); // Calculate x-coordinate
        double y = r * Math.sin(nu); // Calculate y-coordinate
        
        return new double[]{x, y}; // Return position as array
    }
    
    // Method to calculate true anomaly using iterative method
    private double getAnomaly(Planet planet, double M) {
        double E = M; // Initialize eccentric anomaly
        
        for (int i = 0; i < 100; i++) { // Iterate for maximum 100 times
            double E_new = E - (E - planet.getEccentricity() * Math.sin(E) - M) /
                    (1 - planet.getEccentricity() * Math.cos(E)); // Update eccentric anomaly
            if (Math.abs(E_new - E) < 1e-8) { // Check for convergence
                break;
            }
            E = E_new; // Update eccentric anomaly
        }
        
        return 2 * Math.atan2(Math.sqrt(1 + planet.getEccentricity())
                * Math.sin(E / 2), Math.sqrt(1 - planet.getEccentricity()) * Math.cos(E / 2)); // Calculate true anomaly
    }
}

