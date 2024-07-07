package com.example.rightelfm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budgets_gen")
    @SequenceGenerator(name = "budgets_gen", sequenceName = "budgets_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String budgetName;
    private Double budgetCapAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "usedBudget")
    private List<Expense> expenses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Double getBudgetCapAmount() {
        return budgetCapAmount;
    }

    public void setBudgetCapAmount(Double budgetCapAmount) {
        this.budgetCapAmount = budgetCapAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
