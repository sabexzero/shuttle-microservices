package org.example.pilotrankservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PilotExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pilotId;
    private Integer experience;

    public PilotExperience updateExperience(Integer newExperience) {
        return PilotExperience
                .builder()
                .id(this.id)
                .experience(newExperience)
                .build();
    }
}
