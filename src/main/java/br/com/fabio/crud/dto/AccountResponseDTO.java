package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.AccountType;
import lombok.Data;

@Data
public class AccountResponseDTO {

    private String accountNumber;

    private String agency;

    private CostumerResponseDTO costumer;

    private AccountType accountType;
}
