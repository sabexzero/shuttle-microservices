package com.example.tripmanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Planet {
    private String name;
    private Double semiMajorAxis; // большая полуось (a) в астрономических единицах
    private Double eccentricity; // эксцентриситет орбиты (e)
    private Integer orbitalPeriod; // орбитальный период (T) в днях
    private Double longitudeOfPerihelion; // долгота перицентра (w) в градусах
    private Double meanOrbitalVelocity; // средняя орбитальная скорость (v) в км/с
    private Orbit orbit;
    
}