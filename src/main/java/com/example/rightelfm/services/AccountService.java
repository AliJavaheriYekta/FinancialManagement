package com.example.rightelfm.services;

import com.example.rightelfm.models.Account;
import com.example.rightelfm.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id){
        return accountRepository.findById(id);
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateAccountBalance(Account account, Double expenseAmount){
        account.setAccountBalance(account.getAccountBalance() - expenseAmount);
        accountRepository.save(account);
    }

    public Boolean isAccountBalanceSufficient(Account account, Double expenseAmount){
        return account.getAccountBalance() >= expenseAmount;
    }
}
