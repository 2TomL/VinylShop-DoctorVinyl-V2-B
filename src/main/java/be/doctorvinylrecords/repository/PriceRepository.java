package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional <Price> findByUserId(long userId);
}
