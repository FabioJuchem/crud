package br.com.fabio.crud.repository;

import br.com.fabio.crud.domain.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository  extends JpaRepository<Costumer, String> {

    Costumer findByCpf(String cpf);
}
