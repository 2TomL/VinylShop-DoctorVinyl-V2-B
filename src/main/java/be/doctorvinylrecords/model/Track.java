package be.DokterVinyl.model;

public class Track {
    private String trackNr;
    private String trackTitle;
    private String trackTime;

    public Track(String trackNr, String trackTitle, String trackTime) {
        this.trackNr = trackNr;
        this.trackTitle = trackTitle;
        this.trackTime = trackTime;
    }

    public String getTrackNr() {
        return trackNr;
    }

    public void setTrackNr(String trackNr) {
        this.trackNr = trackNr;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

}
