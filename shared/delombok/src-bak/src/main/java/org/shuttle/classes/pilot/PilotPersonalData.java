package org.shuttle.classes.pilot;

import lombok.Data;
import org.shuttle.classes.user.Gender;

import java.time.LocalDate;

@Data
public class PilotPersonalData {
    private String name;
    private String surname;
    private String patronymic;

    private Gender gender;

    private LocalDate birthDate;
}
