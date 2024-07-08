package org.shuttle.messages;

import java.io.Serializable;

public class PilotFeedbackMessage implements Serializable {
    private Integer userRate;
    private Long userId;

    public PilotFeedbackMessage(Integer userRate, Long userId) {
        this.userRate = userRate;
        this.userId = userId;
    }

    public PilotFeedbackMessage() {
    }

    public static PilotFeedbackMessageBuilder builder() {
        return new PilotFeedbackMessageBuilder();
    }

    public Integer getUserRate() {
        return this.userRate;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserRate(Integer userRate) {
        this.userRate = userRate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PilotFeedbackMessage)) return false;
        final PilotFeedbackMessage other = (PilotFeedbackMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userRate = this.getUserRate();
        final Object other$userRate = other.getUserRate();
        if (this$userRate == null ? other$userRate != null : !this$userRate.equals(other$userRate)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PilotFeedbackMessage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userRate = this.getUserRate();
        result = result * PRIME + ($userRate == null ? 43 : $userRate.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }

    public String toString() {
        return "org.shuttle.messages.PilotFeedbackMessage(userRate=" + this.getUserRate() + ", userId=" + this.getUserId() + ")";
    }

    public static class PilotFeedbackMessageBuilder {
        private Integer userRate;
        private Long userId;

        PilotFeedbackMessageBuilder() {
        }

        public PilotFeedbackMessageBuilder userRate(Integer userRate) {
            this.userRate = userRate;
            return this;
        }

        public PilotFeedbackMessageBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public PilotFeedbackMessage build() {
            return new PilotFeedbackMessage(this.userRate, this.userId);
        }

        public String toString() {
            return "org.shuttle.messages.PilotFeedbackMessage.PilotFeedbackMessageBuilder(userRate=" + this.userRate + ", userId=" + this.userId + ")";
        }
    }
}
