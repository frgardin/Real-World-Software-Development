package com.development.software.world.real.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.development.software.world.real.service.BankTransactionParser;
import com.development.software.world.real.service.BankTransactionUseCase;
import com.development.software.world.real.service.FileReader;
import com.development.software.world.real.service.dto.BankTransactionDTO;

import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class BankTransactionCsvUseCase
        implements BankTransactionUseCase {

    @Inject
    BankTransactionParser bankTransactionParser;
    @Inject
    FileReader fileReader;

    @Override
    public List<BankTransactionDTO> getAll(String fileName, String fileExtension) throws IOException {
        return fileReader.readAllLines("/" + fileExtension + "/" + fileName + "." + fileExtension)
                .stream()
                .map(bankTransactionParser::parse)
                .toList();
    }
}
