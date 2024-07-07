package com.example.rightelfm.controllers;

import com.example.rightelfm.models.Account;
import com.example.rightelfm.models.Budget;
import com.example.rightelfm.repositories.AccountRepository;
import com.example.rightelfm.repositories.BudgetRepository;
import com.example.rightelfm.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private BudgetRepository budgetRepository;

    @PostMapping
    public Budget createAccount(@RequestBody Budget budget) {
        return budgetService.save(budget);
    }

    @GetMapping("/{id}")
    public Optional<Budget> getBudgetById(@PathVariable(value = "id") String budgetId){
        return budgetRepository.findById(Long.valueOf(budgetId));
    }
}
