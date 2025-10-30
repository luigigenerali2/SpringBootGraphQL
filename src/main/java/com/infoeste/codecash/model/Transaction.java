package com.infoeste.codecash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_account_id", nullable = false)
    private Account payerAccount;

    @ManyToOne
    @JoinColumn(name = "payee_account_id", nullable = false)
    private Account payeeAccount;

    @Column(name = "transaction_time", nullable = false)
    private Instant TransactionTime;

}
