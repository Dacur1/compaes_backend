package at.compaes.backend.repository;

import at.compaes.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllExpense();

    List<Expense> findAllByOrderByDateDesc();

    List<Expense> findAllByCategory();

    List<Expense> findAllByPaymentMethod();
}
