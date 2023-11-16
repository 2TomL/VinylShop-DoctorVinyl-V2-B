package be.doctorvinylrecords.repository;

import be.doctorvinylrecords.model.ERole;
import be.doctorvinylrecords.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
