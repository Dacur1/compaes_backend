package at.compaes.backend.service;

import at.compaes.backend.model.Expense;
import at.compaes.backend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAllExpenses();
    }

    public List<Expense> findAllByOrderByDateDesc() {
        return expenseRepository.findAllByOrderByDateDesc();
    }

    public List<Expense> findAllByOrderByDateAsc() {
        return expenseRepository.findAllByOrderByDateAsc();
    }

    public List<Expense> findAllByCategory(String category) {
        return expenseRepository.findAllByCategory(category);
    }

    public List<Expense> findAllByPaymentMethod(String paymentMethod) {
        return expenseRepository.findAllByPaymentMethod(paymentMethod);
    }

}
