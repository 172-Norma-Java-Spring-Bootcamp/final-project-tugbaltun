package com.norma.bankingSystem.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.norma.bankingSystem.entity.enums.CardType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;
    private Long customer_id;

}
