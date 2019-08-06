package br.com.fabio.crud.adapter;

import br.com.fabio.crud.domain.Costumer;
import br.com.fabio.crud.dto.CostumerPersistDTO;
import br.com.fabio.crud.dto.CostumerResponseDTO;
import br.com.fabio.crud.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CostumerAdapter implements EntityAdapter<Costumer, CostumerPersistDTO, CostumerResponseDTO> {

    @Autowired
    private  ModelMapper mapper;

    @Autowired
    private CostumerRepository costumerRepository;

    public CostumerAdapter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Costumer toEntity(CostumerPersistDTO dto) {
        Costumer costumer = costumerRepository.findByCpf(dto.getCpf());
        if(costumer.getCpf() == dto.getCpf()){
            this.updateEntity(costumer, dto);
        }
        return mapper.map(dto, Costumer.class);
    }

    @Override
    public CostumerResponseDTO toResponse(Costumer costumer) {
        return mapper.map(costumer, CostumerResponseDTO.class);
    }

    @Override
    public void updateEntity(Costumer costumer, CostumerPersistDTO dto) {
        mapper.map(dto, costumer);
    }
}
