package com.Mangesh.ExpenseTracker.services.expense;

import com.Mangesh.ExpenseTracker.dto.ExpenseDTO;
import com.Mangesh.ExpenseTracker.entity.Expense;
import com.Mangesh.ExpenseTracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImp implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO){
        return (saveOrUpdateExpense(new Expense(),expenseDTO));
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO){
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }


    public Expense updateExpense(Long id, ExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if (optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(),expenseDTO);
        }
        else {
            throw new EntityNotFoundException("Expense is not Present with Id "+id);
        }
    }

    public Expense getExpenseByID(Long id){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if (optionalExpense.isPresent()){
            return optionalExpense.get();
        }else {
            throw new EntityNotFoundException("Id not found"+ id);
        }
    }

    public void deleteExpense(Long id){
        Optional<Expense> optionalExpense=expenseRepository.findById(id);
        if (optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Expense is not present");
        }
    }
}
