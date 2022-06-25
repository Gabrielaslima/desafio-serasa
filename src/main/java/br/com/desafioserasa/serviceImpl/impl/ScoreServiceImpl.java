package br.com.desafioserasa.serviceImpl.impl;

import br.com.desafioserasa.entity.Score;
import br.com.desafioserasa.model.dto.ScoreDTO;
import br.com.desafioserasa.repository.IScoreRepository;
import br.com.desafioserasa.serviceImpl.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    public IScoreRepository scoreRepository;

    @Override
    public ResponseEntity<String> cadastroScore(ScoreDTO scoreDto) {

        try {
            Score score = new Score(scoreDto);
            scoreRepository.save(score);

            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar score.");
        }

    }

}
