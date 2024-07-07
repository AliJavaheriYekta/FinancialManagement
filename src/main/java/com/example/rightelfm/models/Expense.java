package com.example.rightelfm.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_gen")
    @SequenceGenerator(name = "expenses_gen", sequenceName = "expenses_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String expenseTitle;
    private LocalDate expenseDate;
    private Double expenseAmount;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget usedBudget;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account usedAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Budget getUsedBudget() {
        return usedBudget;
    }

    public void setUsedBudget(Budget usedBudget) {
        this.usedBudget = usedBudget;
    }

    public Account getUsedAccount() {
        return usedAccount;
    }

    public void setUsedAccount(Account usedAccount) {
        this.usedAccount = usedAccount;
    }
}
