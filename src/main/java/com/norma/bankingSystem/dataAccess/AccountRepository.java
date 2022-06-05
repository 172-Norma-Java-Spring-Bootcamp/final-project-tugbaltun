package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value="SELECT * FROM account WHERE (customer_id = :customer_id)", nativeQuery = true)
    List<Account> findByCustomerId(@Param("customer_id") Long customer_id);
}
