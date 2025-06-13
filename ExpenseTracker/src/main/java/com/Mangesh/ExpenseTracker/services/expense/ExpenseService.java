package com.Mangesh.ExpenseTracker.services.expense;

import com.Mangesh.ExpenseTracker.dto.ExpenseDTO;
import com.Mangesh.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseByID(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
        
}
