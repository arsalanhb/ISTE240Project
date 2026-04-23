package org.example.group3_assignment1.repositories;

import org.example.group3_assignment1.models.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChefDAO extends JpaRepository<Chef, Long> {

    List<Chef> findAll();

    Chef findByChefId(Long chefId);

    List<Chef> findByFirstName(String firstName);

    List<Chef> findBySpecialty(String specialty);

    boolean existsBySpecialty(String specialty);

    boolean existsByEmail(String email);

    boolean existsByFirstName(String firstName);

}
