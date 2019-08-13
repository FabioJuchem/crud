package br.com.fabio.databuilder;

import br.com.fabio.crud.domain.Account;
import br.com.fabio.crud.domain.AccountType;
import br.com.fabio.crud.domain.OperationType;
import br.com.fabio.crud.dto.AccountPersistDTO;
import br.com.fabio.crud.dto.CostumerPersistDTO;
import br.com.fabio.crud.dto.HistoricPersistDTO;

public class CrudDataBuilderTest {

    public static final String NAME = "Person name";
    public static final String CPF = "97902459046";
    public static final Account account = new Account();

    public static CostumerPersistDTO costumerPersistDTO() {
        var dto = new CostumerPersistDTO();
        dto.setName(NAME);
        dto.setCpf(CPF);
        return dto;
    }

    public static HistoricPersistDTO historicPersistDTO() {
        var dto = new HistoricPersistDTO();
        dto.setAccount(account);
        dto.setOperationType(OperationType.INPUT);
        dto.setValue(250.0);
        return dto;
    }

    public static AccountPersistDTO accountPersistDTO() {
        var dto = new AccountPersistDTO();
        dto.setCostumer(costumerPersistDTO());
        dto.setAccountNumber("12345");
        dto.setAccountType(AccountType.SAVINGS);
        dto.setAgency("111");
        return dto;
    }

}
