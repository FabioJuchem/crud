package br.com.fabio.adapter;

import br.com.fabio.crud.adapter.CostumerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.fabio.databuilder.CrudDataBuilderTest.costumerPersistDTO;
import static br.com.fabio.databuilder.ModelMapperTestDataBuilder.modelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class CostumerAdapterTest {

    private CostumerAdapter costumerAdapter;

    @BeforeEach
    void setUp(){
        this.costumerAdapter = new CostumerAdapter(modelMapper());
    }

    @Test
    void shouldAdapterToEntity(){
        var dto = costumerPersistDTO();
        var entity = costumerAdapter.toEntity(dto);
        assertEquals(dto.getName(),entity.getName() );
        assertEquals(dto.getCpf(), entity.getCpf());
    }

    @Test
    void shouldAdapterToResponse(){
        var dto = costumerPersistDTO();
        var response = costumerAdapter.toResponse(costumerAdapter.toEntity(dto));
        assertEquals(dto.getCpf(), response.getCpf());
        assertEquals(dto.getName(), response.getName());
    }

    @Test
    void shouldAdapterToUpdateEntity(){
        var dto = costumerPersistDTO();
        var entity = costumerAdapter.toEntity(dto);
        dto.setName("Jose");
        costumerAdapter.updateEntity(entity,dto);
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getCpf(), entity.getCpf());
    }

}
