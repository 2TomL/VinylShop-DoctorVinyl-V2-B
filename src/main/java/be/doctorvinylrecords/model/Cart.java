package be.DokterVinyl.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Vinyl> listOfVinylInCart;

    public Cart() {
        this.listOfVinylInCart = new ArrayList<>();
    }
    public List<Vinyl> getListOfVinylInCart() {
        return listOfVinylInCart;
    }
    public void viewCart(){
        if (listOfVinylInCart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (int i = 0; i < listOfVinylInCart.size(); i++) {
                System.out.println((i + 1) + ". " + listOfVinylInCart.get(i));
            }
        }
    }
    public void addVinylToCart(Vinyl vinyl) {
        this.listOfVinylInCart.add(vinyl);
    }

    public void removeBookFromCart(Vinyl vinyl){
        listOfVinylInCart.remove(vinyl);
    }
    public void removeVinyl(int index) {
        if (index >= 0 && index < listOfVinylInCart.size()) {
            listOfVinylInCart.remove(index);
            System.out.println("Vinyl removed from cart.");
        } else {
            System.out.println("Invalid Vinyl number.");
        }
    }

    public void clearCart(){
        listOfVinylInCart.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "listOfVinylInCart=" + listOfVinylInCart +
                '}';
    }
}
