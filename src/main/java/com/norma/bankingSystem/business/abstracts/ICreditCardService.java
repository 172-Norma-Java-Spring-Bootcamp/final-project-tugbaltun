package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.CreditCard;

import java.util.List;
import java.util.Map;

public interface ICreditCardService {

    List<CreditCard> getAll();

    CreditCard getById(Long id);

    CreditCard add(CreditCard creditCard);

    CreditCard update(Long id, CreditCard creditCard);

    Map<String, Boolean> delete(Long id);
}
