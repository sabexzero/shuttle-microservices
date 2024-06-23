package com.example.tripmanagementservice.domain;


import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Trip {
    private Long id;
    private OffsetDateTime start;
    private OffsetDateTime end;
    
    private Long userId;
    private Long startPlanetId;
    private Long endPlanetId;
    private BigDecimal price;
}
