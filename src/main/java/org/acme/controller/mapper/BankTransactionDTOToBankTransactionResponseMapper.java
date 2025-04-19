package org.acme.controller.mapper;

import org.acme.controller.dto.response.BankTransactionResponse;
import org.acme.service.dto.BankTransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface BankTransactionDTOToBankTransactionResponseMapper {

    BankTransactionResponse map(BankTransactionDTO source);
}
