package com.Mangesh.ExpenseTracker.services.income;

import com.Mangesh.ExpenseTracker.dto.IncomeDTO;
import com.Mangesh.ExpenseTracker.entity.Expense;
import com.Mangesh.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    Income getIncomeByID(Long id);

    public void deleteIncome(Long id);
}
