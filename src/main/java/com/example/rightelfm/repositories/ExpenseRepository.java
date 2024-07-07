package com.example.rightelfm.repositories;

import com.example.rightelfm.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository <Expense, Long> {
    List<Expense> findByUsedBudget_User_IdAndExpenseDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
    List<Expense> findByUsedAccount_Id(Long accountId);
    List<Expense> findByUsedAccount_IdAndExpenseDateBetween(Long accountId, LocalDate startDate, LocalDate endDate);
}
