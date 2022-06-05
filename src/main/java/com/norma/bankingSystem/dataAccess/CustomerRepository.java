package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
