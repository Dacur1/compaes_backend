package at.compaes.backend.controller;

import at.compaes.backend.model.Expense;
import at.compaes.backend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.findAllExpenses();

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam(required = false) String sort) {
        List<Expense> expenses;

        if ("asc".equals(sort)) {
            expenses = expenseService.findAllByOrderByDateAsc();
        } else if ("desc".equals(sort)) {
            expenses = expenseService.findAllByOrderByDateDesc();
        } else {
            expenses = expenseService.findAllExpenses();
        }

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam(required = false) String category) {
        List<Expense> expenses;

        if (category != null) {
            expenses = expenseService.findAllByCategory(category);
        } else {
            expenses = expenseService.findAllExpenses();
        }
        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getExpensesByPaymentMethod(@RequestParam(required = false) String paymentMethod) {
        List<Expense> expenses;

        if (paymentMethod != null) {
            expenses = expenseService.findAllByPaymentMethod(paymentMethod);
        } else {
            expenses = expenseService.findAllExpenses();
        }
        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
