package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.ICreditCardService;
import com.norma.bankingSystem.dataAccess.CreditCardRepository;
import com.norma.bankingSystem.entity.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreditCardManager implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;


    @Override
    public List<CreditCard> getAll() {
        return null;
    }

    @Override
    public CreditCard getById(Long id) {
        return null;
    }

    @Override
    public CreditCard add(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(Long id, CreditCard creditCard) {
        return null;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return null;
    }
}
