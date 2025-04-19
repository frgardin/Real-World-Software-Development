package com.development.software.world.real.controller.dto.response;


import java.time.LocalDate;


public record BankTransactionResponse(
        LocalDate date,
        Double amount,
        String description
) {
}
