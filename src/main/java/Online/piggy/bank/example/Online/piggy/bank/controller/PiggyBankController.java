package Online.piggy.bank.example.Online.piggy.bank.controller;

import Online.piggy.bank.example.Online.piggy.bank.entity.PiggyBank;
import Online.piggy.bank.example.Online.piggy.bank.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/piggy-bank")
public class PiggyBankController {
    @Autowired
    private PiggyBankService piggyBankService;

    @PostMapping("/create")
    public ResponseEntity<PiggyBank> createPiggyBank() {
        PiggyBank createdPiggyBank = piggyBankService.createPiggyBank();
        return new ResponseEntity<>(createdPiggyBank, HttpStatus.CREATED);
    }

    @PostMapping("/break")
    public ResponseEntity<Double> breakPiggyBank() {
        double withdrawnAmount = piggyBankService.breakPiggyBank();
        return new ResponseEntity<>(withdrawnAmount, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<PiggyBank> getPiggyBankStatus() {
        PiggyBank piggyBank = piggyBankService.getCurrentPiggyBank();
        return new ResponseEntity<>(piggyBank, HttpStatus.OK);
    }


}
