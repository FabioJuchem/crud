package br.com.fabio.crud.crudService;

import br.com.fabio.crud.adapter.AccountAdapter;
import br.com.fabio.crud.adapter.HistoricAdapter;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.AccountResponseDTO;
import br.com.fabio.crud.dto.HistoricResponseDTO;
import br.com.fabio.crud.repository.AccountRepository;
import br.com.fabio.crud.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrudService {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountAdapter accountAdapter;

    @Autowired
    private HistoricAdapter historicAdapter;

    @Transactional
    public AccountResponseDTO saveAccount (AccountPersistDTO dto){
        accountRepository.save(accountAdapter.toEntity(dto));
        return accountAdapter.toResponse(accountAdapter.toEntity(dto));
    }

    public List<AccountResponseDTO> getAllAccounts(){
        return accountAdapter.toResponse(accountRepository.findAll());
    }

    public AccountResponseDTO findOne(String number){
        return accountAdapter.toResponse(accountRepository.findByAccountNumber(number));
    }

    public List<HistoricResponseDTO> getHistoric(String number){
       var account = accountRepository.findByAccountNumber(number);
       var historic = historicRepository.findAllByAccount(account);
       return historicAdapter.toResponse(historic);
    }

    @Transactional
    public Double deposit(String number, Double value) {
        var account = accountRepository.findByAccountNumber(number);
        account.deposit(value);
        return account.getBalance();
    }

    @Transactional
    public Double withdraw(String number, Double value){
        var account = accountRepository.findByAccountNumber(number);
        account.withDraw(value);
        return account.getBalance();
    }

    @Transactional
    public Double transfer(String number, Double value, String receiver){
        var account = accountRepository.findByAccountNumber(number);
        var accountReceiver = accountRepository.findByAccountNumber(receiver);
        account.transfer(value, accountReceiver);
        return account.getBalance();
    }
    @Transactional
    public void delete(String number){
        var account =  accountRepository.findByAccountNumber(number);
        accountRepository.delete(account);
    }

    @Transactional
    public AccountResponseDTO update(AccountPersistDTO dto){
        var updated = accountRepository.findByAccountNumber(dto.getAccountNumber());
        accountAdapter.updateEntity(updated, dto);
        return accountAdapter.toResponse(updated);
    }
}
