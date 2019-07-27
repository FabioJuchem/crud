package br.com.fabio.crud.domain;

import java.time.LocalDateTime;

public class Historic {

    private LocalDateTime date = LocalDateTime.now();

    private Double value;

    private OperationType operationType;
}
