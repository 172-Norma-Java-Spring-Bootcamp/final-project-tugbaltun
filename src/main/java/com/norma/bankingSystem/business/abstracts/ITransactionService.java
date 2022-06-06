package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.Account;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public interface ITransactionService {
    Account deposit(BigDecimal depositAmount, String account_number, HttpSession session);
    Account withdraw(BigDecimal withdrawAmount, String account_number, HttpSession session);

}
