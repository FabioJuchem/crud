package br.com.fabio.crud.adapter;

import br.com.fabio.crud.domain.Account;
import br.com.fabio.crud.domain.Costumer;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.AccountResponseDTO;
import br.com.fabio.crud.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountAdapter implements EntityAdapter<Account, AccountPersistDTO, AccountResponseDTO> {

    @Autowired
    private  ModelMapper mapper;

    @Autowired
    private CostumerRepository costumerRepository;

    public AccountAdapter(ModelMapper mapper) {
        this.mapper = mapper;
    }
    @Autowired
    private CostumerAdapter adapter;

    @Override
    public Account toEntity(AccountPersistDTO dto) {
        return mapper.map(dto, Account.class);
    }

    @Override
    public AccountResponseDTO toResponse(Account account) {
        return mapper.map(account, AccountResponseDTO.class);
    }

    @Override
    public void updateEntity(Account account, AccountPersistDTO dto) {
        mapper.map(dto, account);
    }

}
