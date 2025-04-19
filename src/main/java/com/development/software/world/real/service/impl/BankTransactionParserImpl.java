package com.development.software.world.real.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import com.development.software.world.real.service.BankTransactionParser;
import com.development.software.world.real.service.dto.BankTransactionDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static java.util.Optional.ofNullable;


@ApplicationScoped
public class BankTransactionParserImpl implements BankTransactionParser {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final Integer DEFAULT_CSV_LINE_SIZE = 3;

    @Override
    public BankTransactionDTO parse(String line) {
        return getBankTransactionDTOFromString(line.split(DEFAULT_SEPARATOR));
    }

    private BankTransactionDTO getBankTransactionDTOFromString(String[] values) {
        return ofNullable(values)
                .filter(v -> v.length == DEFAULT_CSV_LINE_SIZE)
                .map(v -> new BankTransactionDTO(
                                parseLocalDateFromString(v[0]),
                                Double.valueOf(v[1]),
                                v[2]
                        )
                )
                .orElseThrow(() -> new IllegalArgumentException("value is wrong" + Arrays.toString(values)));
    }

    private static LocalDate parseLocalDateFromString(String v) {
        return LocalDate.parse(v, DATE_PATTERN);
    }
}
