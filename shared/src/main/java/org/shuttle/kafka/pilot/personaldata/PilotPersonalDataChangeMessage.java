package org.shuttle.kafka.pilot.personaldata;

import org.shuttle.classes.pilot.PilotPersonalData;

import java.time.LocalDateTime;

public class PilotPersonalDataChangeMessage {
    private PilotPersonalData newpilotPersonalData;
    private LocalDateTime dateTime;

    public PilotPersonalDataChangeMessage() {
    }

    public PilotPersonalDataChangeMessage(PilotPersonalData newpilotPersonalData, LocalDateTime dateTime) {
        this.newpilotPersonalData = newpilotPersonalData;
        this.dateTime = dateTime;
    }

    public static PilotPersonalDataChangeMessageBuilder builder() {
        return new PilotPersonalDataChangeMessageBuilder();
    }

    public PilotPersonalData getPilotPersonalData() {
        return this.newpilotPersonalData;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setPilotPersonalData(PilotPersonalData pilotPersonalData) {
        this.newpilotPersonalData = pilotPersonalData;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PilotPersonalDataChangeMessage)) return false;
        final PilotPersonalDataChangeMessage other = (PilotPersonalDataChangeMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pilotPersonalData = this.getPilotPersonalData();
        final Object other$pilotPersonalData = other.getPilotPersonalData();
        if (this$pilotPersonalData == null ? other$pilotPersonalData != null : !this$pilotPersonalData.equals(other$pilotPersonalData))
            return false;
        final Object this$dateTime = this.getDateTime();
        final Object other$dateTime = other.getDateTime();
        if (this$dateTime == null ? other$dateTime != null : !this$dateTime.equals(other$dateTime)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PilotPersonalDataChangeMessage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pilotPersonalData = this.getPilotPersonalData();
        result = result * PRIME + ($pilotPersonalData == null ? 43 : $pilotPersonalData.hashCode());
        final Object $dateTime = this.getDateTime();
        result = result * PRIME + ($dateTime == null ? 43 : $dateTime.hashCode());
        return result;
    }

    public String toString() {
        return "PilotPersonalDataChangeMessage(pilotPersonalData=" + this.getPilotPersonalData() + ", dateTime=" + this.getDateTime() + ")";
    }

    public static class PilotPersonalDataChangeMessageBuilder {
        private PilotPersonalData newpilotPersonalData;
        private LocalDateTime dateTime;

        PilotPersonalDataChangeMessageBuilder() {
        }

        public PilotPersonalDataChangeMessageBuilder newpilotPersonalData(PilotPersonalData newpilotPersonalData) {
            this.newpilotPersonalData = newpilotPersonalData;
            return this;
        }

        public PilotPersonalDataChangeMessageBuilder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public PilotPersonalDataChangeMessage build() {
            return new PilotPersonalDataChangeMessage(this.newpilotPersonalData, this.dateTime);
        }

        public String toString() {
            return "PilotPersonalDataChangeMessage.PilotPersonalDataChangeMessageBuilder(newpilotPersonalData=" + this.newpilotPersonalData + ", dateTime=" + this.dateTime + ")";
        }
    }
}
