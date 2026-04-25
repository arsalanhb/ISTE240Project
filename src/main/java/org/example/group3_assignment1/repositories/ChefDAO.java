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


    @Modifying
    @Query("UPDATE Chef c set c.salary = :salary, c.yrsOfExperience = :yrsOfExperiencewhere, c.email = :email WHERE c.chefId = :chefId ")
    void updateProgressionById(@Param("chefId") Long chefId,@Param("email") String email,@Param("salary") Double salary, @Param("yrsOfExperience") Double yrsOfExperience);

    boolean existsByLastName(String lastName);

    void deleteByChefId(Long chefId);
}
