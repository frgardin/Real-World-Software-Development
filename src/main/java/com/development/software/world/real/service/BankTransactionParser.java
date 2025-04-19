package com.development.software.world.real.service;

import com.development.software.world.real.service.dto.BankTransactionDTO;

public interface BankTransactionParser {

    BankTransactionDTO parse(String line);
}
