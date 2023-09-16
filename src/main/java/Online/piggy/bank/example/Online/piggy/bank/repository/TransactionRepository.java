package Online.piggy.bank.example.Online.piggy.bank.repository;

import Online.piggy.bank.example.Online.piggy.bank.entity.Transaction;
import Online.piggy.bank.example.Online.piggy.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
