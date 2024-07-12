package org.shuttle.classes.trip;

import org.shuttle.classes.pilot.PilotRank;

import java.time.LocalDate;

public class TripInfo {
    private String departurePlanet;
    private String arrivalPlanet;

    private LocalDate date;

    private TripDifficulty tripDifficulty;
    private PilotRank pilotRank;

    public TripInfo() {
    }

    public String getDeparturePlanet() {
        return this.departurePlanet;
    }

    public String getArrivalPlanet() {
        return this.arrivalPlanet;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public TripDifficulty getTripDifficulty() {
        return this.tripDifficulty;
    }

    public PilotRank getPilotRank() {
        return this.pilotRank;
    }

    public void setDeparturePlanet(String departurePlanet) {
        this.departurePlanet = departurePlanet;
    }

    public void setArrivalPlanet(String arrivalPlanet) {
        this.arrivalPlanet = arrivalPlanet;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTripDifficulty(TripDifficulty tripDifficulty) {
        this.tripDifficulty = tripDifficulty;
    }

    public void setPilotRank(PilotRank pilotRank) {
        this.pilotRank = pilotRank;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TripInfo)) return false;
        final TripInfo other = (TripInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$departurePlanet = this.getDeparturePlanet();
        final Object other$departurePlanet = other.getDeparturePlanet();
        if (this$departurePlanet == null ? other$departurePlanet != null : !this$departurePlanet.equals(other$departurePlanet))
            return false;
        final Object this$arrivalPlanet = this.getArrivalPlanet();
        final Object other$arrivalPlanet = other.getArrivalPlanet();
        if (this$arrivalPlanet == null ? other$arrivalPlanet != null : !this$arrivalPlanet.equals(other$arrivalPlanet))
            return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$tripDifficulty = this.getTripDifficulty();
        final Object other$tripDifficulty = other.getTripDifficulty();
        if (this$tripDifficulty == null ? other$tripDifficulty != null : !this$tripDifficulty.equals(other$tripDifficulty))
            return false;
        final Object this$pilotRank = this.getPilotRank();
        final Object other$pilotRank = other.getPilotRank();
        if (this$pilotRank == null ? other$pilotRank != null : !this$pilotRank.equals(other$pilotRank)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TripInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $departurePlanet = this.getDeparturePlanet();
        result = result * PRIME + ($departurePlanet == null ? 43 : $departurePlanet.hashCode());
        final Object $arrivalPlanet = this.getArrivalPlanet();
        result = result * PRIME + ($arrivalPlanet == null ? 43 : $arrivalPlanet.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $tripDifficulty = this.getTripDifficulty();
        result = result * PRIME + ($tripDifficulty == null ? 43 : $tripDifficulty.hashCode());
        final Object $pilotRank = this.getPilotRank();
        result = result * PRIME + ($pilotRank == null ? 43 : $pilotRank.hashCode());
        return result;
    }

    public String toString() {
        return "TripInfo(departurePlanet=" + this.getDeparturePlanet() + ", arrivalPlanet=" + this.getArrivalPlanet() + ", date=" + this.getDate() + ", tripDifficulty=" + this.getTripDifficulty() + ", pilotRank=" + this.getPilotRank() + ")";
    }
}
