package br.com.fabio.crud.dto;

import br.com.fabio.crud.domain.OperationType;
import lombok.Data;

@Data
public class OperationTypeDTO {

    private String value;

    private String description;

    public OperationTypeDTO(OperationType operationType) {
        this.value = operationType.toString();
        this.description = operationType.getDescription();
    }
}
