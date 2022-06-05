package com.norma.bankingSystem.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credit_card_id;
    private Long card_id;
    private LocalDate cut_off_date;
    private LocalDate due_date;
    private LocalDate next_billing_date;
    private LocalDate next_payment_date;
    @Column(columnDefinition = "numeric default 0")
    private BigDecimal debt_from_last_statement;
    @Column(columnDefinition = "numeric default 0")
    private BigDecimal current_debt;
    @Column(columnDefinition = "numeric default 1000")
    private BigDecimal total_limit;
    @Column(columnDefinition = "numeric default 1000")
    private BigDecimal available_limit;
    private String card_number;
    private int cvc;
    private LocalDate valid_thru;

}
