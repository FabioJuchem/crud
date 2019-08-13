package br.com.fabio.crud.crudController;


import br.com.fabio.crud.crudService.CrudService;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.AccountResponseDTO;
import br.com.fabio.crud.dto.HistoricResponseDTO;
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

    @GetMapping("findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountResponseDTO> findAllAccounts(){
        return crudService.getAllAccounts();
    }

    @GetMapping("gethistoric/{number}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HistoricResponseDTO> getHistoric(@PathVariable("number") String number){
        return crudService.getHistoric(number);
    }

    @GetMapping("findOne/{number}")
    @ResponseStatus(HttpStatus.FOUND)
    public AccountResponseDTO findAllAccounts(@PathVariable("number") String number){
        return crudService.findOne(number);
    }

    @PostMapping ("deposit/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Double deposit(@PathVariable("number") String number, @RequestBody Double value ){
       return crudService.deposit(number, value);
    }

    @PostMapping("withdraw/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Double withDraw(@PathVariable("number") String number, @RequestBody Double value){
        return crudService.withdraw(number, value);
    }

    @PostMapping("transfer/{number}/{receiver}")
    @ResponseStatus(HttpStatus.OK)
    public Double transfer(@PathVariable("number") String number, @RequestBody Double value ,@PathVariable("receiver") String receiver){
        return crudService.transfer(number, value, receiver);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountResponseDTO update(@RequestBody AccountPersistDTO dto){
        return crudService.update(dto);
    }

    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("number") String number){
         crudService.delete(number);
    }
}
