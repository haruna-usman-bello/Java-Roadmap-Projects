package  com.projects;

import java.util.Arrays;

public class Main {
     static void main(String[] args) {
        System.out.println("Starting Expense Tracker");
         System.out.println("Arguments:" +  Arrays.toString(args));
         ExpenseManager expenseManager = new ExpenseManager();
         System.out.println(expenseManager);
    }
}