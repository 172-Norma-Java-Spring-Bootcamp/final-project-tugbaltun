package com.norma.bankingSystem.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.norma.bankingSystem.entity.enums.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_id;
    private Long account_id;
    private String beneficiary;
    private String beneficiary_acc_no;
    private double amount;
    private String reference_no;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String reason_code;
    private LocalDateTime created_at;

}
