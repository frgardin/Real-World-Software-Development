package com.development.software.world.real.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import com.development.software.world.real.controller.dto.response.BankTransactionResponse;
import com.development.software.world.real.controller.mapper.BankTransactionDTOToBankTransactionResponseMapper;
import com.development.software.world.real.service.BankTransactionUseCase;

import java.io.IOException;
import java.util.List;

import static com.development.software.world.real.controller.ResourcePath.BANK_RESOURCE;

@Path(BANK_RESOURCE)
public class BankTransactionResource {

    @Inject
    BankTransactionUseCase bankTransactionUseCase;
    @Inject
    BankTransactionDTOToBankTransactionResponseMapper bankTransactionDTOToBankTransactionResponseMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankTransactionResponse> getAllTransactions(
            @QueryParam("fileName") String fileName,
            @QueryParam("fileExtension") String fileExtension) throws IOException {
        return bankTransactionUseCase.getAll(fileName, fileExtension)
                .stream()
                .map(bankTransactionDTOToBankTransactionResponseMapper::map)
                .toList();
    }
}
