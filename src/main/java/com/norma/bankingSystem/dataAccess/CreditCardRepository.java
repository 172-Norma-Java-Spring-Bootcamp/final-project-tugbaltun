package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
