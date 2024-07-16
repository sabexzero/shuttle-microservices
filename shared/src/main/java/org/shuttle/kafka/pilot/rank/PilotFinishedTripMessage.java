package org.shuttle.kafka.pilot.rank;

import java.time.LocalDateTime;

public class PilotFinishedTripMessage {
    private Long pilotId;
    private Integer tripDifficultyLevel;
    private Integer pilotRankLevel;

    private LocalDateTime dateTime;

    public PilotFinishedTripMessage() {
    }

    public Long getPilotId() {
        return this.pilotId;
    }

    public Integer getTripDifficultyLevel() {
        return this.tripDifficultyLevel;
    }

    public Integer getPilotRankLevel() {
        return this.pilotRankLevel;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public void setTripDifficultyLevel(Integer tripDifficultyLevel) {
        this.tripDifficultyLevel = tripDifficultyLevel;
    }

    public void setPilotRankLevel(Integer pilotRankLevel) {
        this.pilotRankLevel = pilotRankLevel;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PilotFinishedTripMessage)) return false;
        final PilotFinishedTripMessage other = (PilotFinishedTripMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pilotId = this.getPilotId();
        final Object other$pilotId = other.getPilotId();
        if (this$pilotId == null ? other$pilotId != null : !this$pilotId.equals(other$pilotId)) return false;
        final Object this$tripDifficultyLevel = this.getTripDifficultyLevel();
        final Object other$tripDifficultyLevel = other.getTripDifficultyLevel();
        if (this$tripDifficultyLevel == null ? other$tripDifficultyLevel != null : !this$tripDifficultyLevel.equals(other$tripDifficultyLevel))
            return false;
        final Object this$pilotRankLevel = this.getPilotRankLevel();
        final Object other$pilotRankLevel = other.getPilotRankLevel();
        if (this$pilotRankLevel == null ? other$pilotRankLevel != null : !this$pilotRankLevel.equals(other$pilotRankLevel))
            return false;
        final Object this$dateTime = this.getDateTime();
        final Object other$dateTime = other.getDateTime();
        if (this$dateTime == null ? other$dateTime != null : !this$dateTime.equals(other$dateTime)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PilotFinishedTripMessage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pilotId = this.getPilotId();
        result = result * PRIME + ($pilotId == null ? 43 : $pilotId.hashCode());
        final Object $tripDifficultyLevel = this.getTripDifficultyLevel();
        result = result * PRIME + ($tripDifficultyLevel == null ? 43 : $tripDifficultyLevel.hashCode());
        final Object $pilotRankLevel = this.getPilotRankLevel();
        result = result * PRIME + ($pilotRankLevel == null ? 43 : $pilotRankLevel.hashCode());
        final Object $dateTime = this.getDateTime();
        result = result * PRIME + ($dateTime == null ? 43 : $dateTime.hashCode());
        return result;
    }

    public String toString() {
        return "PilotFinishedTripMessage(pilotId=" + this.getPilotId() + ", tripDifficultyLevel=" + this.getTripDifficultyLevel() + ", pilotRankLevel=" + this.getPilotRankLevel() + ", dateTime=" + this.getDateTime() + ")";
    }
}
