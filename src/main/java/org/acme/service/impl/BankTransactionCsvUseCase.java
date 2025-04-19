package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.service.BankTransactionParser;
import org.acme.service.BankTransactionUseCase;
import org.acme.service.FileReader;
import org.acme.service.dto.BankTransactionDTO;

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
