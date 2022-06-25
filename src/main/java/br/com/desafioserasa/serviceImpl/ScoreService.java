package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.model.dto.ScoreDTO;
import org.springframework.http.ResponseEntity;

public interface ScoreService {

    ResponseEntity<String> cadastroScore(ScoreDTO score);

}
