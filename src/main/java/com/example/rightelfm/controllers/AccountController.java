package com.example.rightelfm.controllers;

import com.example.rightelfm.models.Account;
import com.example.rightelfm.repositories.AccountRepository;
import com.example.rightelfm.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable(value = "id") String accountId){
        return accountRepository.findById(Long.valueOf(accountId));
    }
}
