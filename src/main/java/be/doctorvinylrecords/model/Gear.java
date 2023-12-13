package be.doctorvinylrecords.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @NotNull
    private String productName;
    private double price;
    private boolean accessories;
    private Status status;
    static private long Qt = 0;

    public Gear() {
    }
    public Gear(long productId, String productName, double price, boolean accessories, Status status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.accessories = accessories;
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAccessories() {
        return accessories;
    }

    public void setAccessories(boolean accessories) {
        this.accessories = accessories;
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
        return "Gear{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", accessories=" + accessories +
                ", status=" + status +
                '}';
    }
}
