package com.norma.bankingSystem.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.norma.bankingSystem.entity.enums.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="payment_history")
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_history_id;
    private Long payment_id;
    private Long account_id;
    private Long user_id;
    private String beneficiary;
    private String beneficiary_acc_no;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String reference_no;
    private String reason_code;
    private LocalDateTime created_at;

}
