package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.ITransactionService;
import com.norma.bankingSystem.dataAccess.AccountRepository;
import com.norma.bankingSystem.entity.model.Account;
import com.norma.bankingSystem.entity.model.Customer;
import com.norma.bankingSystem.exception.ApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Service
public class TransactionManager implements ITransactionService {

    @Autowired
    private AccountRepository accountRepository;
    Customer customer;
    BigDecimal currentBalance;
    BigDecimal newBalance;
    @Override
    public Account deposit(BigDecimal depositAmount, String account_number,
                           HttpSession session) {
        if(depositAmount == null || account_number.isEmpty()){
            throw new ApiErrorException("Deposit amount or account number can not be empty" );
        }

        if(depositAmount.intValue() == 0){
            throw new ApiErrorException("Deposit amount can not be of 0 (Zero) value" );
        }

        customer = (Customer)session.getAttribute("customer");

        currentBalance = accountRepository.findByAccountNumber(account_number).getBalance();
        newBalance = currentBalance.add(depositAmount);

        Account accountToUpdate =
                accountRepository.findByAccountNumber(account_number);

        if(accountToUpdate == null){
            throw new ApiErrorException("No account with account number:"+account_number);
        }

        accountToUpdate.setBalance(newBalance);
        return accountRepository.save(accountToUpdate);
    }

    @Override
    public Account withdraw(BigDecimal withdrawAmount, String account_number, HttpSession session) {
        String errorMessage;
        String successMessage;

        if(withdrawAmount == null || account_number.isEmpty()){
            errorMessage = "Withdrawal Amaount and Account Withdrawing From Cannot be Empty";
            throw new ApiErrorException(errorMessage);
        }

        if(withdrawAmount.intValue() == 0){
            errorMessage = "Withdrawal amount can not be 0(Zero) value, please enter a value greater 0 (Zero)";
            throw new ApiErrorException(errorMessage);
        }

        customer = (Customer)session.getAttribute("customer");
        currentBalance = accountRepository.findByAccountNumber(account_number).getBalance();

        if(withdrawAmount.compareTo(currentBalance)==1){
            errorMessage = "Insufficient funds! Please, check withdraw amount.";
            throw new ApiErrorException(errorMessage);
        }

        newBalance = currentBalance.subtract(withdrawAmount);

        Account accountToUpdate =
                accountRepository.findByAccountNumber(account_number);

        if(accountToUpdate == null){
            throw new ApiErrorException("No account with account number:"+account_number);
        }

        accountToUpdate.setBalance(newBalance);
        return accountRepository.save(accountToUpdate);

    }
}
