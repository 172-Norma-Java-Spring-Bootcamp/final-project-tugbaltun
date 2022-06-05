package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
