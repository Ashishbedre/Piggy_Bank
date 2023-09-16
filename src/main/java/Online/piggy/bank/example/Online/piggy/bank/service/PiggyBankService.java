package Online.piggy.bank.example.Online.piggy.bank.service;

import Online.piggy.bank.example.Online.piggy.bank.entity.PiggyBank;
import Online.piggy.bank.example.Online.piggy.bank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiggyBankService {
    @Autowired
    private PiggyBankRepository piggyBankRepository;

    public PiggyBank createPiggyBank() {
        PiggyBank piggyBank = new PiggyBank();
        piggyBank.setBroken(false);
        piggyBank.setBalance(0.0);
        PiggyBank currentPiggyBank = piggyBankRepository.findTopByOrderByIdDesc();
        if(currentPiggyBank.isBroken()==false){
            throw new RuntimeException("Piggy bank is already present.");
        }
        return piggyBankRepository.save(piggyBank);
    }

    public double breakPiggyBank() {
        PiggyBank currentPiggyBank = getCurrentPiggyBank();
        if (!currentPiggyBank.isBroken()) {
            currentPiggyBank.setBroken(true);
            piggyBankRepository.save(currentPiggyBank);
            return currentPiggyBank.getBalance();
        } else {
            throw new RuntimeException("Piggy bank is already broken.");
        }
    }

    public PiggyBank getCurrentPiggyBank() {
        PiggyBank currentPiggyBank = piggyBankRepository.findTopByOrderByIdDesc();
        if (currentPiggyBank == null) {
            return createPiggyBank();
        }
        return currentPiggyBank;
    }


}
