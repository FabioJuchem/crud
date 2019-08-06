package br.com.fabio.crud.crudController;


import br.com.fabio.crud.crudService.CrudService;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.AccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("crud")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @PostMapping("account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO postAccount(@Valid @RequestBody AccountPersistDTO dto){
        return crudService.saveAccount(dto);
    }

    @GetMapping("created")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountResponseDTO> findAllAccounts(){
        return crudService.getAllAccounts();
    }

}
