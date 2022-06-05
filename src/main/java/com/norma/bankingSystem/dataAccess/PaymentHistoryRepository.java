package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
