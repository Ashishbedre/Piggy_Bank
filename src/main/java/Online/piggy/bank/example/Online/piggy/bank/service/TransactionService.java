package Online.piggy.bank.example.Online.piggy.bank.service;

import Online.piggy.bank.example.Online.piggy.bank.entity.PiggyBank;
import Online.piggy.bank.example.Online.piggy.bank.entity.Transaction;
import Online.piggy.bank.example.Online.piggy.bank.entity.User;
import Online.piggy.bank.example.Online.piggy.bank.repository.PiggyBankRepository;
import Online.piggy.bank.example.Online.piggy.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PiggyBankService piggyBankService;

    @Autowired
    private UserService userService;

    @Autowired
    private PiggyBankRepository piggyBankRepository;

    public List<Transaction> getUserTransactions(String username) {
        User user = userService.getUserByUsername(username);
        return transactionRepository.findByUser(user);
    }

    public Transaction addMoneyToPiggyBank(Transaction transaction) {
        PiggyBank currentPiggyBank = piggyBankService.getCurrentPiggyBank();
        User user = userService.getUserByUsername(transaction.getUser().getUsername());
        if (user == null) {
            throw new RuntimeException("User not found.");
        }
        if (currentPiggyBank.isBroken()) {
            throw new RuntimeException("Cannot add money to a broken piggy bank.");
        }

        // Update the piggy bank balance
        double newBalance = currentPiggyBank.getBalance() + transaction.getAmount();
        currentPiggyBank.setBalance(newBalance);
        piggyBankRepository.save(currentPiggyBank);

        // Save the transaction
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

}
