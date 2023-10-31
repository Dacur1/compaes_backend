package at.compaes.backend.repository;

import at.compaes.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllExpense();

    List<Expense> findAllByOrderByDateDesc();

    List<Expense> findAllByCategory(String category);

    List<Expense> findAllByPaymentMethod(String paymentMethod);
}
