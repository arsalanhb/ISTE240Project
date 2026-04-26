//Adham Khalifa -- 418006637

package org.example.group3_assignment1.repositories;
import org.example.group3_assignment1.models.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChefDAO extends JpaRepository<Chef, Long> {

    List<Chef> findAll();

    Optional<Chef> findByChefId(Long chefId);

    @Query("Select c from Chef c where c.firstName = :firstName AND c.lastName = :lastName")
    List<Chef> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Chef> findBySpecialty(String specialty);

    boolean existsBySpecialty(String specialty);

    boolean existsByEmail(String email);

    boolean existsByFirstName(String firstName);

    @Query("SELECT DISTINCT c.specialty from Chef c")
    List<String> findAllSpecialty();


    @Query("UPDATE Chef c SET c.firstName = :firstName, c.lastName = :lastName, c.email = :email, c.salary = :salary, c.specialty = :specialty, c.yrsOfExperience = :yrsOfExperience WHERE c.chefId = :chefId")
    @Modifying(clearAutomatically = true)
    void updateChefById(@Param("chefId") Long chefId, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("salary") Double salary, @Param("specialty") String specialty, @Param("yrsOfExperience") Double yrsOfExperience);

    boolean existsByLastName(String lastName);

    void deleteByChefId(Long chefId);
}
