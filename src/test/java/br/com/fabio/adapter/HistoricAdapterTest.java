package br.com.fabio.adapter;


import br.com.fabio.crud.adapter.HistoricAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.fabio.databuilder.CrudDataBuilderTest.historicPersistDTO;
import static br.com.fabio.databuilder.ModelMapperTestDataBuilder.modelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class HistoricAdapterTest {

    private HistoricAdapter historicAdapter;

    @BeforeEach
    void setUp(){
        this.historicAdapter = new HistoricAdapter(modelMapper());
    }

    @Test
    void shouldAdapterToEntity(){
        var dto = historicPersistDTO();
        var entity = historicAdapter.toEntity(dto);
        assertEquals(dto.getAccount(),entity.getAccount() );
        assertEquals(dto.getOperationType(), entity.getOperationType());
        assertEquals(dto.getValue(), entity.getValue());
    }

    @Test
    void shouldAdapterToResponse(){
        var dto = historicPersistDTO();
        var response = historicAdapter.toResponse(historicAdapter.toEntity(dto));
        assertEquals(dto.getOperationType(), response.getOperationType());
        assertEquals(dto.getValue(), response.getValue());
    }

    @Test
    void shouldAdapterToUpdateEntity(){
        var dto = historicPersistDTO();
        var entity = historicAdapter.toEntity(dto);
        dto.setValue(380.0);
        historicAdapter.updateEntity(entity,dto);
        assertEquals(dto.getOperationType(), entity.getOperationType());
        assertEquals(dto.getValue(), entity.getValue());
    }
}
