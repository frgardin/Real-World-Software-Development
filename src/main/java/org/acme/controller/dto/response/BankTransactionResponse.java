package org.acme.controller.dto.response;


import java.time.LocalDate;


public record BankTransactionResponse(
        LocalDate date,
        Double amount,
        String description
) {
}
