package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.ICardService;
import com.norma.bankingSystem.dataAccess.CardRepository;
import com.norma.bankingSystem.dataAccess.CreditCardRepository;
import com.norma.bankingSystem.dataAccess.DebitCardRepository;
import com.norma.bankingSystem.entity.model.Account;
import com.norma.bankingSystem.entity.model.Card;
import com.norma.bankingSystem.entity.model.CreditCard;
import com.norma.bankingSystem.entity.model.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Service
public class CardManager implements ICardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private DebitCardRepository debitCardRepository;

    @Override
    public List<Card> getAll() {
        return null;
    }

    @Override
    public Card getById(Long id) {
        return null;
    }

    @Override
    public Card add(Card card) {
        Card findCardByCustomerId = cardRepository.findByCustomerId(card.getCustomer_id());
        if(findCardByCustomerId == null){
            cardRepository.save(card);
            Long card_id = cardRepository.findByCustomerId(card.getCustomer_id()).getCard_id();
            creditCardRepository.save(createCreditCard(card_id));
            debitCardRepository.save(createDebitCard(card_id));
        }
        return cardRepository.save(card);
    }

    @Override
    public Card update(Card id, Card card) {
        return null;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return null;
    }

    public CreditCard createCreditCard(Long card_id){
        CreditCard creditCard = new CreditCard();
        DebitCard debitCard = new DebitCard();
        debitCard = createDebitCard(card_id);
        String currentDateToString = LocalDate.now().toString();
        LocalDate date = LocalDate.parse(currentDateToString);
        LocalDate cutOffDate = date.plusDays(20);
        LocalDate dueDate = date.plusMonths(1);
        LocalDate next_billing_date = cutOffDate.plusMonths(1);
        LocalDate next_payment_date = dueDate.plusMonths(1);

        creditCard.setCard_id(card_id);
        creditCard.setCard_number( debitCard.getCard_number());
        creditCard.setCvc(debitCard.getCvc());
        creditCard.setValid_thru(debitCard.getValid_thru());
        creditCard.setCut_off_date(cutOffDate);
        creditCard.setDue_date(dueDate);
        creditCard.setNext_billing_date(next_billing_date);
        creditCard.setNext_payment_date(next_payment_date);

        return creditCard;
    }

    public DebitCard createDebitCard(Long card_id){
        DebitCard debitCard = new DebitCard();

        long first14 = (long) (Math.random() * 100000000000000L);
        long debitCardNumber = 5200000000000000L + first14;

        String currentDateToString = LocalDate.now().toString();
        LocalDate date = LocalDate.parse(currentDateToString);
        LocalDate validThru = date.plusYears(5);

        int cvc_number = (int) (Math.random() * 1000L);

        debitCard.setCard_id(card_id);
        debitCard.setCard_number( Long.toString(debitCardNumber));
        debitCard.setCvc(cvc_number);
        debitCard.setValid_thru(validThru);

        return debitCard;
    }

}
