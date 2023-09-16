package Online.piggy.bank.example.Online.piggy.bank.repository;

import Online.piggy.bank.example.Online.piggy.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
