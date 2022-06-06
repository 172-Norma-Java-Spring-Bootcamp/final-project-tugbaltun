package com.norma.bankingSystem.apicontrollers;

import com.norma.bankingSystem.business.abstracts.IAccountService;
import com.norma.bankingSystem.business.abstracts.ITransactionService;
import com.norma.bankingSystem.entity.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    ITransactionService transactionService;

    @Autowired
    public void setTransactionService(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PutMapping("/account/deposit/{deposit_amount}/{account_number}")
    public ResponseEntity<Account> deposit(
            @PathVariable(value = "deposit_amount") BigDecimal depositAmount,
            @PathVariable(value = "account_number") String account_number,
            HttpSession session) {
        return ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(transactionService.deposit(depositAmount, account_number, session));
    }

    @PutMapping("/account/withdraw/{withdraw_amount}/{account_number}")
    public ResponseEntity<Account> withdraw(
            @PathVariable(value = "withdraw_amount") BigDecimal withdraw_amount,
            @PathVariable(value = "account_number") String account_number,
            HttpSession session) {
        return ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(transactionService.withdraw(withdraw_amount, account_number, session));
    }
}
