package org.example.pilotmanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
    private Long id;
    
    private String name;
    private String surname;
    private String patronymic;

    private Gender gender;

    private LocalDate birthDate;
    
    private String phoneNumber;
    private String email;
    
    private PilotRank rank;
    private Integer tripsAmount;
    private Long experience;

    private LocalDate registrationDate;

    public Pilot updatePersonalData(PilotPersonalData personalData){
        return Pilot.builder()
                .id(null)
                .name(personalData.getName())
                .surname(personalData.getSurname())
                .patronymic(personalData.getPatronymic())
                .gender(personalData.getGender())
                .birthDate(birthDate)
                .phoneNumber(phoneNumber)
                .email(email)
                .tripsAmount(tripsAmount)
                .rank(rank)
                .experience(0L)
                .build();
    }
}


