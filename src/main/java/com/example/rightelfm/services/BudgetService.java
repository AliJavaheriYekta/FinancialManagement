package com.example.rightelfm.services;

import com.example.rightelfm.models.Budget;
import com.example.rightelfm.models.Expense;
import com.example.rightelfm.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> findAll(){
        return budgetRepository.findAll();
    }

    public Optional<Budget> findById(Long id){
        return budgetRepository.findById(id);
    }

    public Budget save(Budget account){
        return budgetRepository.save(account);
    }

    public void deleteById(Long id) {
        budgetRepository.deleteById(id);
    }

    public boolean isBudgetCapExceeded(Budget budget, Double additionalExpense){
        Double totalExpenses = budget.getExpenses().stream().mapToDouble(Expense::getExpenseAmount).sum();
        return (totalExpenses + additionalExpense) > budget.getBudgetCapAmount();
    }
}
