package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;
import com.example.cnExpense.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private IncomeService incomeService;

    @PostMapping("/save/{incomeId}")
    public Income saveExpense(@PathVariable Integer incomeId, @RequestBody Expense expense) {
        Income income = incomeService.getIncomeById(incomeId);
        return expenseService.saveExpense(income,expense);
    }
}
