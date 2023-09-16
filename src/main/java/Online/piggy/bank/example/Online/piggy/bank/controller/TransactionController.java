package Online.piggy.bank.example.Online.piggy.bank.controller;

import Online.piggy.bank.example.Online.piggy.bank.entity.Transaction;
import Online.piggy.bank.example.Online.piggy.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Transaction>> getUserTransactions(@PathVariable String username) {
        List<Transaction> transactions = transactionService.getUserTransactions(username);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addMoneyToPiggyBank(@RequestBody Transaction transaction) {
        Transaction addedTransaction = transactionService.addMoneyToPiggyBank(transaction);
        return new ResponseEntity<>(addedTransaction, HttpStatus.CREATED);
    }

}