package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.entity.Score;
import br.com.desafioserasa.model.dto.ScoreDTO;
import br.com.desafioserasa.repository.IScoreRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScoreServiceImpl {

    @Autowired
    private ScoreService scoreService;

    @Mock
    private IScoreRepository scoreRepository;

    @Test
    public void testeCadastroScore() {

        ScoreDTO scoreDto = new ScoreDTO();
        Score score = new Score();

        Mockito.when(scoreRepository.save(Mockito.any())).thenReturn(score);
        ResponseEntity<?> response = scoreService.cadastroScore(scoreDto);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }

}
