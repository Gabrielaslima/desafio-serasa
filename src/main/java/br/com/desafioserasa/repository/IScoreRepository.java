package br.com.desafioserasa.repository;


import br.com.desafioserasa.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IScoreRepository extends JpaRepository<Score, Long> {

    //SELECT S.SCORE_DESCRICAO FROM SCORE S WHERE S.INICIAL <= 701 AND 701 <= S.VALOR_FINAL

    @Query(value = "SELECT s.scoreDescricao FROM br.com.desafioserasa.entity.Score s WHERE s.inicial <= :scorePessoa AND :scorePessoa <= s.valorFinal")
    public String findScoreDescricao(@Param("scorePessoa") Long scorePessoa);

}
