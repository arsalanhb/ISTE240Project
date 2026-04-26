// Student Name: Munzier Kashef | Student ID: 761008741
package org.example.group3_assignment1.repositories;

import org.example.group3_assignment1.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName);

    @Query("select c from Customer c where c.assignedWaiter.id = :waiterId")
    List<Customer> findByWaiterId(@Param("waiterId") int waiterId);

    @Modifying
    @Transactional
    @Query("update Customer c set c.assignedWaiter = (select w from Waiter w where w.id = :waiterId) where c.customerId = :customerId")
    void updateCustomerWaiter(@Param("customerId") int customerId, @Param("waiterId") int waiterId);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.assignedWaiter = null WHERE c.assignedWaiter.id = :waiterId")
    void unassignWaiterFromCustomers(@Param("waiterId") int waiterId);
}
