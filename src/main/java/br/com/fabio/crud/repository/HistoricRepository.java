package br.com.fabio.crud.repository;

import br.com.fabio.crud.domain.Account;
import br.com.fabio.crud.domain.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, Long> {

    List<Historic> findAllByAccount(Account account);
}
