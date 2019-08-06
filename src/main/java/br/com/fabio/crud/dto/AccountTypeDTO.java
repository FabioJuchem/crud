package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.AccountType;
import lombok.Data;

@Data
public class AccountTypeDTO {

    private String value;

    private String description;

    public AccountTypeDTO(AccountType accountType) {
        this.value = accountType.toString();
        this.description = accountType.getDescription();
    }
}
