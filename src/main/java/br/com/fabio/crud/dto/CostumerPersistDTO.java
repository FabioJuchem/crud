package br.com.fabio.crud.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CostumerPersistDTO implements Serializable {

    private static final long serialVersionUID = 20L;

    @Size(min = 5, max = 50, message = "textsize.valid")
    @NotBlank(message="name.required")
    private String name;

    @Size(min = 11, message = "textsize.valid")
    @NotBlank(message="cpf.required")
    private String cpf;

}
