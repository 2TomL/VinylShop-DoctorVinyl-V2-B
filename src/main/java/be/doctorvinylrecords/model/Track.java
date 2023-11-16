package be.doctorvinylrecords.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Track {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String trackNr;
    private String trackTitle;
    private String trackTime;

    public Track(String trackNr, String trackTitle, String trackTime) {
        this.trackNr = trackNr;
        this.trackTitle = trackTitle;
        this.trackTime = trackTime;
    }
    public Track() {    }

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
