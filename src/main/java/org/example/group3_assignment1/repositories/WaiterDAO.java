//Muhammad Arsalan Habib - 403000286
package org.example.group3_assignment1.repositories;

import org.example.group3_assignment1.models.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WaiterDAO extends JpaRepository<Waiter, Integer> {

    List<Waiter> findAll();

    List<Waiter> findByFirstName(String firstName);

    boolean existsByFirstName(String firstName);

    @Query("SELECT w FROM Waiter w WHERE w.salary >= :minSalary ORDER BY w.salary DESC")
    List<Waiter> findBySalaryGreaterThanEqual(@Param("minSalary") double minSalary);

    @Modifying
    @Transactional
    @Query("UPDATE Waiter w SET w.salary = :salary WHERE w.id = :id")
    int updateSalaryById(@Param("id") int id, @Param("salary") double salary);
}