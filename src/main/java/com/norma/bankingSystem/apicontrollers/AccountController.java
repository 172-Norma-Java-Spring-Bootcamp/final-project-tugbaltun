package com.norma.bankingSystem.apicontrollers;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.norma.bankingSystem.business.abstracts.IAccountService;
import com.norma.bankingSystem.entity.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    IAccountService accountService;

    @Autowired
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getById(@PathVariable(value = "id") Long id) {
        return Optional.ofNullable(accountService.getById(id))
                .map(account -> ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE).body(account))
                .orElse(notFound().build());
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAll() {
        return ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE).body(accountService.getAll());
    }

    @PostMapping("/account")
    public ResponseEntity<Account> add(@RequestBody Account account) {
        return created(fromCurrentRequest().build().toUri())
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(accountService.add(account));
    }
}
