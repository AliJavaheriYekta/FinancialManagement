package com.example.rightelfm.services;

import com.example.rightelfm.models.Expense;
import com.example.rightelfm.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    public ExpenseRepository expenseRepository;

    public List<Expense> getExpensesByDataRange(Long userId, LocalDate startDate, LocalDate endDate){
        return expenseRepository.findByUsedBudget_User_IdAndExpenseDateBetween(userId,startDate,endDate);
    }

    public List<Expense> getExpensesByAccount(Long accountId){
        return expenseRepository.findByUsedAccount_Id(accountId);
    }

    public List<Expense> getExpensesByDataRangeAndAccount(Long accountId, LocalDate startDate, LocalDate endDate){
        return expenseRepository.findByUsedAccount_IdAndExpenseDateBetween(accountId, startDate, endDate);
    }
}
