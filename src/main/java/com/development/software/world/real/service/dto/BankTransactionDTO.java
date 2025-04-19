package com.development.software.world.real.service.dto;

import java.time.LocalDate;

public record BankTransactionDTO(
        LocalDate date,
        Double amount,
        String description
) {
}
