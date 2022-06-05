package com.norma.bankingSystem.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String identity_number;
    private LocalDate date_of_registration;
    private LocalDateTime last_successful_login;
    private LocalDateTime last_wrong_entry;

}
