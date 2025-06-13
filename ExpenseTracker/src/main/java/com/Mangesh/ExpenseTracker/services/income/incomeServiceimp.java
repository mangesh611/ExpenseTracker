package com.Mangesh.ExpenseTracker.services.income;

import com.Mangesh.ExpenseTracker.dto.ExpenseDTO;
import com.Mangesh.ExpenseTracker.dto.IncomeDTO;
import com.Mangesh.ExpenseTracker.entity.Expense;
import com.Mangesh.ExpenseTracker.entity.Income;
import com.Mangesh.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class incomeServiceimp implements IncomeService{

    private final IncomeRepository incomeRepository;

    public Income postIncome(IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income(),incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO){
    income.setTitle(incomeDTO.getTitle());
    income.setDate(incomeDTO.getDate());
    income.setAmount(incomeDTO.getAmount());
    income.setCategory(incomeDTO.getCategory());
    income.setDescription(incomeDTO.getDescription());

    return incomeRepository.save(income);
    }


    public List<IncomeDTO> getAllIncome(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(),incomeDTO);
        }
        else {
            throw new EntityNotFoundException("Expense is not Present with Id "+id);
        }
    }

    public Income getIncomeByID(Long id){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            return optionalIncome.get();
        }else {
            throw new EntityNotFoundException("Id not found"+ id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Expense is not present");
        }
    }

}
