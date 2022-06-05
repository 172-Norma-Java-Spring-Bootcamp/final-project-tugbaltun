package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
