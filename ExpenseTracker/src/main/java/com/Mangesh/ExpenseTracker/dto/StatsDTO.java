package com.Mangesh.ExpenseTracker.dto;

import com.Mangesh.ExpenseTracker.entity.Expense;
import com.Mangesh.ExpenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {

    private Double income;

    private Double expense;

    private Income latestIncome;

    private Expense latestExpense;

    private double balance;

    private double minIncome;

    private double maxIncome;

    private double minExpense;

    private double maxExpense;
}
