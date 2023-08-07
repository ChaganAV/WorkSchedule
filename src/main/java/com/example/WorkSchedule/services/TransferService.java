package com.example.WorkSchedule.services;

import com.example.WorkSchedule.models.Account;
import com.example.WorkSchedule.repositoryes.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws AccountNotFoundException {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());
        BigDecimal senderNewAccount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAccount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender,senderNewAccount);
        accountRepository.changeAmount(idReceiver, receiverNewAccount);
    }
}
