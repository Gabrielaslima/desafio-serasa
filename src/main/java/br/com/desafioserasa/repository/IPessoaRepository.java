package br.com.desafioserasa.repository;

import br.com.desafioserasa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {
}
