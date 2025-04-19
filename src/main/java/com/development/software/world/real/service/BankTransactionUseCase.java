package com.development.software.world.real.service;

import com.development.software.world.real.service.dto.BankTransactionDTO;

import java.io.IOException;
import java.util.List;


public interface BankTransactionUseCase {

    List<BankTransactionDTO> getAll(String fileName, String fileExtension) throws IOException;
}
