package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.IDebitCardService;
import com.norma.bankingSystem.dataAccess.DebitCardRepository;
import com.norma.bankingSystem.entity.model.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DebitCardManager implements IDebitCardService {

    @Autowired
    private DebitCardRepository debitCardRepository;

    @Override
    public List<DebitCard> getAll() {
        return null;
    }

    @Override
    public DebitCard getById(Long id) {
        return null;
    }

    @Override
    public DebitCard add(DebitCard debitCard) {
        return debitCardRepository.save(debitCard);
    }

    @Override
    public DebitCard update(Long id, DebitCard debitCard) {
        return null;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return null;
    }
}
