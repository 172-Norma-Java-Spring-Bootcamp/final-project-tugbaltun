package com.norma.bankingSystem.dataAccess;

import com.norma.bankingSystem.entity.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(value="SELECT * FROM card WHERE (customer_id = :customer_id)", nativeQuery = true)
    Card findByCustomerId(@Param("customer_id") Long customer_id);

    @Query(value="SELECT * FROM card WHERE (customer_id = :customer_id and card_type = :card_type)", nativeQuery = true)
    Card findByCustomerIdAndCardType(@Param("customer_id") Long customer_id, @Param("card_type") String card_type);
}
