package com.infoeste.codecash.controller;

import com.infoeste.codecash.repository.TransactionRepository;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {
    private final TransactionRepository transactionRepository;
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


}
