package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
