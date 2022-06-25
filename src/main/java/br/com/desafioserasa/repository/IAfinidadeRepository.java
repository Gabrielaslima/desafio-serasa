package br.com.desafioserasa.repository;

import br.com.desafioserasa.entity.Afinidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAfinidadeRepository extends JpaRepository<Afinidade, String> {

    //SELECT E.NOME FROM AFINIDADE A LEFT JOIN  ESTADO_AFINIDADE EA ON A.ID = EA.AFINIDADE_ID INNER JOIN ESTADO E ON EA.ESTADO_ID = E.ID WHERE A.REGIAO = 'Sudeste'

    @Query(value = "SELECT e.nome FROM AFINIDADE a LEFT JOIN br.com.desafioserasa.entity.EstadoAfinidade ea ON a.id = ea.estadoAfinidadeId.afinidadeId " +
            "INNER JOIN ESTADO e ON ea.estadoAfinidadeId.estadoId = e.id " +
            "WHERE a.regiao = :regiaoPessoa")
    public List<String> findAllEstadosPorAfinidadePessoa(@Param("regiaoPessoa") String regiaoPessoa);


}
