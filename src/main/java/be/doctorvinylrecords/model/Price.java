package be.doctorvinylrecords.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Price(double price, User user) {
        this.price = price;
        this.user = user;
    }

    public Price() {

    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void addAmountToPrice(Double priceAmount) {
        this.price += priceAmount;
    }
}
