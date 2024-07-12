package org.shuttle.classes.pilot;

import org.shuttle.classes.user.Gender;

import java.time.LocalDate;

public class PilotPersonalData {
    private String name;
    private String surname;
    private String patronymic;

    private Gender gender;

    private LocalDate birthDate;

    public PilotPersonalData() {
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public Gender getGender() {
        return this.gender;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PilotPersonalData)) return false;
        final PilotPersonalData other = (PilotPersonalData) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$patronymic = this.getPatronymic();
        final Object other$patronymic = other.getPatronymic();
        if (this$patronymic == null ? other$patronymic != null : !this$patronymic.equals(other$patronymic))
            return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$birthDate = this.getBirthDate();
        final Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PilotPersonalData;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $patronymic = this.getPatronymic();
        result = result * PRIME + ($patronymic == null ? 43 : $patronymic.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        return result;
    }

    public String toString() {
        return "PilotPersonalData(name=" + this.getName() + ", surname=" + this.getSurname() + ", patronymic=" + this.getPatronymic() + ", gender=" + this.getGender() + ", birthDate=" + this.getBirthDate() + ")";
    }
}
