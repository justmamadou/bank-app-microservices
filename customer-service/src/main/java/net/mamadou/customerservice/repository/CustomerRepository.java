package net.mamadou.customerservice.repository;

import net.mamadou.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
