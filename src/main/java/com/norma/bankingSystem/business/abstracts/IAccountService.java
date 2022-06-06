package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    Account getById(Long id);

    List<Account> getAll();
    Account add(Account account);

    Map<String, Boolean> delete(Long id);


}
