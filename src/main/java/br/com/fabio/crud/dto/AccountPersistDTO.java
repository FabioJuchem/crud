package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.AccountType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AccountPersistDTO implements Serializable {

    private static final long serialVersionUID = 21L;

    @NotBlank(message = "accountnumber.required")
    private String accountNumber;

    @NotBlank(message = "agency.required")
    private String agency;

    @NotNull(message = "constumer.required")
    private CostumerPersistDTO costumer;

    @NotNull(message = "accounttype.required")
    private AccountType accountType;

    public CostumerPersistDTO getCostumer() {
        return this.costumer;
    }
}
