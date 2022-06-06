package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.IAccountService;
import com.norma.bankingSystem.dataAccess.AccountRepository;
import com.norma.bankingSystem.dataAccess.CardRepository;
import com.norma.bankingSystem.dataAccess.CreditCardRepository;
import com.norma.bankingSystem.dataAccess.DebitCardRepository;
import com.norma.bankingSystem.entity.model.*;
import com.norma.bankingSystem.exception.ApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Service
public class AccountManager implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private DebitCardRepository debitCardRepository;



    LocalDateTime currentDate = LocalDateTime.now();

    @Override
    public Account getById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new ApiErrorException("No account with id:" + id));
    }

    @Override
    public List<Account> getAll() {
        if (accountRepository.findAll().isEmpty()) {
            throw new ApiErrorException("Account cannot be found in the cache");
        }
        return accountRepository.findAll();
    }

    @Override
    public Account add(Account account) {
        List<Account> findAccountListByUserId = accountRepository.findByCustomerId(account.getCustomer_id());
        Long card_id;
        if(findAccountListByUserId.isEmpty()){
            Card card = new Card();
            card.setCustomer_id(account.getCustomer_id());
            cardRepository.save(card);
            card_id = cardRepository.findByCustomerId(card.getCustomer_id()).getCard_id();
            creditCardRepository.save(createCreditCard(card_id));
            debitCardRepository.save(createDebitCard(card_id));
            account.setCard_id(card_id);
        }

        long first14 = (long) (Math.random() * 100000000000000L);
        long number = 5200000000000000L + first14;
        String accountNumber = "TR370001"+number+"75";
        account.setAccount_number(accountNumber);

        account.setDate_of_creation(currentDate);

        if(account.getName().isEmpty() || account.getAccount_type().isEmpty()){
            throw new ApiErrorException("Account name or Account Type can not be empty!");
        }
        return accountRepository.save(account);
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
        creditCard.setDebt_from_last_statement(BigDecimal.ZERO);

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
