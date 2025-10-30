package com.infoeste.codecash.service;

import com.infoeste.codecash.dto.CreateTransactionInput;
import com.infoeste.codecash.model.Account;
import com.infoeste.codecash.model.Transaction;
import com.infoeste.codecash.repository.AccountRepository;
import com.infoeste.codecash.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(CreateTransactionInput createTransactionInput) {
        Account payer = accountRepository.findById(createTransactionInput.payerAccountID())
                .orElseThrow(() -> new IllegalAccessError("payer account not found"));
        Account receiver = accountRepository.findById(createTransactionInput.payeeAccountID())
                .orElseThrow(() -> new IllegalAccessError("payee account not found"));
        if(payer.getBalance().compareTo(createTransactionInput.amount())<0) {
            throw new IllegalAccessError("Insufficient funds");
        }
        if(payer.getId().equals(receiver.getId())) {
            throw new IllegalAccessError("payer and receiver both are the same");
        }

        payer.setBalance(payer.getBalance().subtract(createTransactionInput.amount()));
        receiver.setBalance(receiver.getBalance().add(createTransactionInput.amount()));
        accountRepository.saveAll(List.of(payer, receiver));
        Transaction transaction = new Transaction();
        transaction.setAmount(createTransactionInput.amount());
        transaction.setPayerAccount(payer);
        transaction.setPayeeAccount(receiver);
        transaction.setTransactionTime(Instant.now());
        return transactionRepository.save(transaction);
    }
}
