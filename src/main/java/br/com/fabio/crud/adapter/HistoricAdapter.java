package br.com.fabio.crud.adapter;

import br.com.fabio.crud.domain.Historic;
import br.com.fabio.crud.dto.HistoricPersistDTO;
import br.com.fabio.crud.dto.HistoricResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoricAdapter implements EntityAdapter<Historic, HistoricPersistDTO, HistoricResponseDTO> {

    @Autowired
    private  ModelMapper mapper;

    public HistoricAdapter(ModelMapper mapper) {
        this.mapper = mapper;

    }

    @Override
    public Historic toEntity(HistoricPersistDTO dto) {
        return mapper.map(dto, Historic.class);
    }

    @Override
    public HistoricResponseDTO toResponse(Historic historic) {
        return mapper.map(historic, HistoricResponseDTO.class);
    }

    @Override
    public void updateEntity(Historic historic, HistoricPersistDTO dto) {
        mapper.map(dto, historic);
    }
}
