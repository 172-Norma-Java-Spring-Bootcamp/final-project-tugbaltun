package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.Recipient;

public interface ITransferService {
    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount) throws Exception;

    void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount);
}
