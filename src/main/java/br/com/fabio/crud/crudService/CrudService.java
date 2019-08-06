package br.com.fabio.crud.crudService;

import br.com.fabio.crud.adapter.AccountAdapter;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.AccountResponseDTO;
import br.com.fabio.crud.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrudService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountAdapter accountAdapter;

    @Transactional
    public AccountResponseDTO saveAccount (AccountPersistDTO dto){
        accountRepository.save(accountAdapter.toEntity(dto));
        return accountAdapter.toResponse(accountAdapter.toEntity(dto));
    }

    public List<AccountResponseDTO> getAllAccounts(){
        return accountAdapter.toResponse(accountRepository.findAll());
    }

}
