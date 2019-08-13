package br.com.fabio.adapter;

import br.com.fabio.crud.adapter.AccountAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.fabio.databuilder.CrudDataBuilderTest.accountPersistDTO;
import static br.com.fabio.databuilder.ModelMapperTestDataBuilder.modelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class AccountAdapterTest {

    private AccountAdapter accountAdapter;

    @BeforeEach
    void setUp(){
        this.accountAdapter = new AccountAdapter(modelMapper());
    }

    @Test
    void shouldAdapterToEntity(){
        var dto = accountPersistDTO();
        var entity = accountAdapter.toEntity(dto);
        assertEquals(dto.getAccountNumber(),entity.getAccountNumber());
        assertEquals(dto.getAccountType(), entity.getAccountType());
        assertEquals(dto.getAgency(), entity.getAgency());
    }

    @Test
    void shouldAdapterToResponse(){
        var dto = accountPersistDTO();
        var response = accountAdapter.toResponse(accountAdapter.toEntity(dto));
        assertEquals(dto.getAccountNumber(),response.getAccountNumber());
        assertEquals(dto.getAccountType(), response.getAccountType());
        assertEquals(dto.getAgency(), response.getAgency());
    }

    @Test
    void shouldAdapterToUpdateEntity(){
        var dto = accountPersistDTO();
        var entity = accountAdapter.toEntity(dto);
        dto.setAgency("999");
        accountAdapter.updateEntity(entity,dto);
        assertEquals(dto.getAccountNumber(),entity.getAccountNumber());
        assertEquals(dto.getAccountType(), entity.getAccountType());
        assertEquals(dto.getAgency(), entity.getAgency());
    }

}
