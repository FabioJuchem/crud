package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.Account;
import br.com.fabio.crud.domain.OperationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoricResponseDTO {

    private Long id;

    private LocalDateTime date;

    private Double value;

    private OperationType operationType;

    private Account account;
}
