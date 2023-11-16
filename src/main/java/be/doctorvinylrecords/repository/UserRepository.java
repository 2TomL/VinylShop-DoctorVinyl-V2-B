package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u " +
            "WHERE lower(u.username) LIKE lower(concat('%', :query, '%')) " +
            "OR lower(u.email) LIKE lower(concat('%', :query, '%'))")
    List<User> searchUsers(String query);
}
