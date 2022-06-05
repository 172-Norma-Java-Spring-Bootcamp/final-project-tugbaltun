package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.DebitCard;

import java.util.List;
import java.util.Map;

public interface IDebitCardService {

    List<DebitCard> getAll();

    DebitCard getById(Long id);

    DebitCard add(DebitCard debitCard);

    DebitCard update(Long id, DebitCard debitCard);

    Map<String, Boolean> delete(Long id);
}
