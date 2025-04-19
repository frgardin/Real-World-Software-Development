package com.development.software.world.real.controller.mapper;

import com.development.software.world.real.controller.dto.response.BankTransactionResponse;
import com.development.software.world.real.service.dto.BankTransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface BankTransactionDTOToBankTransactionResponseMapper {

    BankTransactionResponse map(BankTransactionDTO source);
}
