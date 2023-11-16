package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VinylRepository extends JpaRepository <Vinyl, Long>{
    @Query("SELECT b FROM Vinyl b " +
            "WHERE lower(b.title) LIKE lower(concat('%', :query, '%')) " +
            "OR lower(b.artist) LIKE lower(concat('%', :query, '%'))")
    List<Vinyl> searchVinyl(@Param("query") String query);
}
