package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.Account;
import br.com.fabio.crud.domain.OperationType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class HistoricPersistDTO implements Serializable {

    private static final long serialVersionUID = 23L;

    @NotBlank(message = "value.required")
    private Double value;

    @NotNull(message = "field.required")
    private OperationType operationType;

    @NotNull(message = "account.required")
    private Account account;
}
