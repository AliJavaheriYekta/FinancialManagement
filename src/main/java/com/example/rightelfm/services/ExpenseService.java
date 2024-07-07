package com.example.rightelfm.services;

import com.example.rightelfm.exceptions.InvalidRequestException;
import com.example.rightelfm.models.Account;
import com.example.rightelfm.models.Budget;
import com.example.rightelfm.models.Expense;
import com.example.rightelfm.repositories.ExpenseRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private  AccountService accountService;
    @Autowired
    private  BudgetService budgetService;

    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }

    public Optional<Expense> findById(Long id){
        return expenseRepository.findById(id);
    }

    public Expense save(Expense expense){
        Account account = expense.getUsedAccount();
        if (!accountService.isAccountBalanceSufficient(account, expense.getExpenseAmount())){
            throw new InvalidRequestException("Insufficient balance.");
        }

        Budget budget = expense.getUsedBudget();
        if (budgetService.isBudgetCapExceeded(budget, expense.getExpenseAmount())){
            throw new InvalidRequestException("Expense exceeds the budget cap.");
        }

        accountService.updateAccountBalance(account, expense.getExpenseAmount());

        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}
