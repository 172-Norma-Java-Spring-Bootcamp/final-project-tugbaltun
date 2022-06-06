package com.norma.bankingSystem.business.concretes;

import com.norma.bankingSystem.business.abstracts.ITransferService;
import com.norma.bankingSystem.dataAccess.AccountRepository;
import com.norma.bankingSystem.entity.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferManager implements ITransferService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void betweenAccountsTransfer(String transferFrom, String transferTo, String amount)  {
        Account transferFromAccount = accountRepository.findByAccountNumber(transferFrom);
        Account transferToAccount = accountRepository.findByAccountNumber(transferFrom);

        transferFromAccount.setBalance(transferFromAccount.getBalance().subtract(new BigDecimal(amount)));
        transferToAccount.setBalance(transferToAccount.getBalance().subtract(new BigDecimal(amount)));
        accountRepository.save(transferFromAccount);
        accountRepository.save(transferToAccount);
    }

/*    @Override
    public void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount) {

    }*/
}
