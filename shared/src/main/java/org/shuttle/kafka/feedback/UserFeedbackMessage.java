package org.shuttle.kafka.feedback;

import java.io.Serializable;

public class UserFeedbackMessage implements Serializable {
    private Integer pilotRate;
    private Long pilotId;

    public UserFeedbackMessage(Integer pilotRate, Long pilotId) {
        this.pilotRate = pilotRate;
        this.pilotId = pilotId;
    }

    public UserFeedbackMessage() {
    }

    public static UserFeedbackMessageBuilder builder() {
        return new UserFeedbackMessageBuilder();
    }

    public Integer getPilotRate() {
        return this.pilotRate;
    }

    public Long getPilotId() {
        return this.pilotId;
    }

    public void setPilotRate(Integer pilotRate) {
        this.pilotRate = pilotRate;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserFeedbackMessage)) return false;
        final UserFeedbackMessage other = (UserFeedbackMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pilotRate = this.getPilotRate();
        final Object other$pilotRate = other.getPilotRate();
        if (this$pilotRate == null ? other$pilotRate != null : !this$pilotRate.equals(other$pilotRate)) return false;
        final Object this$pilotId = this.getPilotId();
        final Object other$pilotId = other.getPilotId();
        if (this$pilotId == null ? other$pilotId != null : !this$pilotId.equals(other$pilotId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserFeedbackMessage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pilotRate = this.getPilotRate();
        result = result * PRIME + ($pilotRate == null ? 43 : $pilotRate.hashCode());
        final Object $pilotId = this.getPilotId();
        result = result * PRIME + ($pilotId == null ? 43 : $pilotId.hashCode());
        return result;
    }

    public String toString() {
        return "org.shuttle.messages.UserFeedbackMessage(pilotRate=" + this.getPilotRate() + ", pilotId=" + this.getPilotId() + ")";
    }

    public static class UserFeedbackMessageBuilder {
        private Integer pilotRate;
        private Long pilotId;

        UserFeedbackMessageBuilder() {
        }

        public UserFeedbackMessageBuilder pilotRate(Integer pilotRate) {
            this.pilotRate = pilotRate;
            return this;
        }

        public UserFeedbackMessageBuilder pilotId(Long pilotId) {
            this.pilotId = pilotId;
            return this;
        }

        public UserFeedbackMessage build() {
            return new UserFeedbackMessage(this.pilotRate, this.pilotId);
        }

        public String toString() {
            return "org.shuttle.messages.UserFeedbackMessage.UserFeedbackMessageBuilder(pilotRate=" + this.pilotRate + ", pilotId=" + this.pilotId + ")";
        }
    }
}
