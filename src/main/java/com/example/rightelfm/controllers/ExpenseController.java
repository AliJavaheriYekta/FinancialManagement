package com.example.rightelfm.controllers;

import com.example.rightelfm.models.Budget;
import com.example.rightelfm.models.Expense;
import com.example.rightelfm.repositories.BudgetRepository;
import com.example.rightelfm.repositories.ExpenseRepository;
import com.example.rightelfm.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping
    public Expense createAccount(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable(value = "id") String expenseId){
        return expenseRepository.findById(Long.valueOf(expenseId));
    }
}
