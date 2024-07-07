package com.example.rightelfm.repositories;

import com.example.rightelfm.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository <Budget, Long> {
}
