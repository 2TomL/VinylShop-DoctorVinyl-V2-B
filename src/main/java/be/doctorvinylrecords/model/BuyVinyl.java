package be.doctorvinylrecords.model;

import jakarta.persistence.*;

@Entity
public class BuyVinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Vinyl vinyl;
    private Price price;

    public BuyVinyl(){

    }

}
