package com.norma.bankingSystem.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.norma.bankingSystem.entity.enums.AccountType;
import com.norma.bankingSystem.entity.enums.CurrencyUnit;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    private Long customer_id;
    private Long branch_id;
    private String account_number;
    private String name;
    private BigDecimal balance;
    private LocalDateTime date_of_creation;
    private String account_type;
    private String currency_unit;
    private Long card_id;
}
