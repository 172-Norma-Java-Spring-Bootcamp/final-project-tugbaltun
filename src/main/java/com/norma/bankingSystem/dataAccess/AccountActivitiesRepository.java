package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.AccountActivities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountActivitiesRepository extends JpaRepository<AccountActivities, Long> {
}
