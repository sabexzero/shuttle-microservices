package org.shuttle.kafka.pilot.rank;

import java.time.LocalDateTime;

public class PilotRankChangeMessage {
    private Long pilotId;
    private LocalDateTime dateTime;

    public PilotRankChangeMessage() {
    }

    public Long getPilotId() {
        return this.pilotId;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PilotRankChangeMessage)) return false;
        final PilotRankChangeMessage other = (PilotRankChangeMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pilotId = this.getPilotId();
        final Object other$pilotId = other.getPilotId();
        if (this$pilotId == null ? other$pilotId != null : !this$pilotId.equals(other$pilotId)) return false;
        final Object this$dateTime = this.getDateTime();
        final Object other$dateTime = other.getDateTime();
        if (this$dateTime == null ? other$dateTime != null : !this$dateTime.equals(other$dateTime)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PilotRankChangeMessage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pilotId = this.getPilotId();
        result = result * PRIME + ($pilotId == null ? 43 : $pilotId.hashCode());
        final Object $dateTime = this.getDateTime();
        result = result * PRIME + ($dateTime == null ? 43 : $dateTime.hashCode());
        return result;
    }

    public String toString() {
        return "PilotRankChangeMessage(pilotId=" + this.getPilotId() + ", dateTime=" + this.getDateTime() + ")";
    }
}
