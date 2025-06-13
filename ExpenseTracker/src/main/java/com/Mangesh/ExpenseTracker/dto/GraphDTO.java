package com.Mangesh.ExpenseTracker.dto;

import com.Mangesh.ExpenseTracker.entity.Expense;
import com.Mangesh.ExpenseTracker.entity.Income;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;
    private List<Income> incomeList;


}
