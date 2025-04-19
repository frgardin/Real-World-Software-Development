package org.acme.service.dto;

import java.time.LocalDate;

public record BankTransactionDTO(
        LocalDate date,
        Double amount,
        String description
) {
}
