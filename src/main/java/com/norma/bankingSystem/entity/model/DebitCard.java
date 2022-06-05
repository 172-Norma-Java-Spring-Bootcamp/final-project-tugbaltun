package com.norma.bankingSystem.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="debit_card")
public class DebitCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long debit_card_id;
    private Long card_id;
    @Column(columnDefinition = "numeric default 5000.00")
    private BigDecimal daily_withdrawal_limit;
    @Column(columnDefinition = "numeric default 5000.00")
    private BigDecimal remaining_withdrawal_limit;
    private String card_number;
    private LocalDate valid_thru;
    private int cvc;
    private String name;

}
