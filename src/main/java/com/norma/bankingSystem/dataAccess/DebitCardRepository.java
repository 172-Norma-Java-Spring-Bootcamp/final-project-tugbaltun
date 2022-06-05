package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {
}
