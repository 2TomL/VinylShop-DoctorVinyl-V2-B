package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.BuyVinyl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyVinylRepository extends JpaRepository<BuyVinyl, Long> {
}
