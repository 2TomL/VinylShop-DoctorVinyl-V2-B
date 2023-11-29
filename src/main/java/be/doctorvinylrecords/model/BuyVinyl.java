package be.doctorvinylrecords.model;

import jakarta.persistence.*;

@Entity
public class BuyVinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Vinyl vinyl;
    @OneToOne(fetch = FetchType.EAGER)
    private User user;
    private double price;

    public BuyVinyl(Vinyl vinyl, User user, double price) {
        this.vinyl = vinyl;
        this.user = user;
        this.price = price;
    }

    protected BuyVinyl(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vinyl getVinyl() {
        return vinyl;
    }

    public void setVinyl(Vinyl vinyl) {
        this.vinyl = vinyl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
