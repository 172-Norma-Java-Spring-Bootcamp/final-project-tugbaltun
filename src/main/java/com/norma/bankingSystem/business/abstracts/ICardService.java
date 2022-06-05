package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.Card;

import java.util.List;
import java.util.Map;

public interface ICardService {

    List<Card> getAll();

    Card getById(Long id);

    Card add(Card card);

    Card update(Card id, Card card);

    Map<String, Boolean> delete(Long id);
}
