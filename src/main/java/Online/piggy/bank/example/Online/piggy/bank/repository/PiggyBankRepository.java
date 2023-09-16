package Online.piggy.bank.example.Online.piggy.bank.repository;

import Online.piggy.bank.example.Online.piggy.bank.entity.PiggyBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiggyBankRepository extends JpaRepository<PiggyBank, Long> {
    PiggyBank findTopByOrderByIdDesc();
}