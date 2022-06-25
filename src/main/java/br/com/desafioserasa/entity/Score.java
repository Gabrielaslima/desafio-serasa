package br.com.desafioserasa.entity;

import br.com.desafioserasa.model.dto.ScoreDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "SCORE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scoreDescricao;

    private long inicial;

    private long valorFinal;

    public Score(ScoreDTO scoreDto) {
        this.scoreDescricao = scoreDto.getScoreDescricao();
        this.inicial = scoreDto.getInicial();
        this.valorFinal = scoreDto.getValorFinal();
    }
}
