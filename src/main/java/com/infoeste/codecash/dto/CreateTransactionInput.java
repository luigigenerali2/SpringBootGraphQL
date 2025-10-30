package com.infoeste.codecash.dto;

import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionInput(
        BigDecimal amount,
        UUID payerAccountID,
        UUID payeeAccountID
) {

}
