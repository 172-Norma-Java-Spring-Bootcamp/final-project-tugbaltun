package com.norma.bankingSystem.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="account_activities")
public class AccountActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long acc_activities_id;
    private Long account_id;
    private LocalDateTime transaction_time;
    private BigDecimal amount;
    private BigDecimal available_balance;
    private String explanation;

}
