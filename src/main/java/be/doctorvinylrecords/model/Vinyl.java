package be.doctorvinylrecords.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Entity
public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vinylId;
    @NotNull
    private String artist;
    @NotNull
    private String title;
    private String catalogNr;
    private String label;
    private String country;
    private Category category;
    private int released;
    private Format format;
    private boolean bestSeller;
    @OneToMany
    private List<Track> trackList;
    private double price;
    private Status status;
    static private long Qt = 0;

    public Vinyl(String artist, String title, String catalogNr,String label, String country, Category category, int released, Format format, boolean bestSeller, List<Track> trackList, double price, Status status) {
        this.artist = artist;
        this.title = title;
        this.catalogNr = catalogNr;
        this.label = label;
        this.country = country;
        this.category = category;
        this.released = released;
        this.format = format;
        this.bestSeller = bestSeller;
        this.trackList = trackList;
        this.price = price;
        this.status = status;
        setVinylId(vinylId);
    }
    public Vinyl(){
    }

    public void setVinylId(long vinylId) {
        this.vinylId = vinylId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatalogNr() {
        return catalogNr;
    }

    public void setCatalogNr(String catalogNr) {
        this.catalogNr = catalogNr;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static long getQt() {
        return Qt;
    }

    public static void setQt(long qt) {
        Qt = qt;
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "vinylId=" + vinylId +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", catalogNr='" + catalogNr + '\'' +
                ", label='" + label + '\'' +
                ", country='" + country + '\'' +
                ", category=" + category +
                ", released=" + released +
                ", format=" + format +
                ", bestSeller=" + bestSeller +
                ", trackList=" + trackList +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
