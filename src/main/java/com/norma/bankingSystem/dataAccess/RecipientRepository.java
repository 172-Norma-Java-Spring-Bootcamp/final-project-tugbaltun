package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
