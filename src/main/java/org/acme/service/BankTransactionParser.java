package org.acme.service;

import org.acme.service.dto.BankTransactionDTO;

public interface BankTransactionParser {


    BankTransactionDTO parse(String line);
}
