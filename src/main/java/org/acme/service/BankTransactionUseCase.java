package org.acme.service;

import org.acme.service.dto.BankTransactionDTO;

import java.io.IOException;
import java.util.List;


public interface BankTransactionUseCase {

    List<BankTransactionDTO> getAll(String fileName, String fileExtension) throws IOException;
}
