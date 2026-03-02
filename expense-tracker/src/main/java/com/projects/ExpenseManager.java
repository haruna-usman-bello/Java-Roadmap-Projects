package com.projects;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private final List<Expense> expensesList;

    public ExpenseManager() {
       this.expensesList = loadExpenses();
    }

    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        System.out.println("Loading Expenses");
        return expenses;
    }

    @Override
    public String toString() {
        return "expensesList=" + expensesList;
    }
}
