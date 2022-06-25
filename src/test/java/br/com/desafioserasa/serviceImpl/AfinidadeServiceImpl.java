package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.entity.Afinidade;
import br.com.desafioserasa.model.dto.AfinidadeDTO;
import br.com.desafioserasa.repository.IAfinidadeRepository;
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
public class AfinidadeServiceImpl {

    @Autowired
    private AfinidadeService afinidadeService;

    @Mock
    private IAfinidadeRepository afinidadeRepository;

    @Test
    public void testCadastroAfinidade() {
        AfinidadeDTO afinidadeDto = new AfinidadeDTO();
        Afinidade afinidade = new Afinidade();

        Mockito.when(afinidadeRepository.save(Mockito.any())).thenReturn(afinidade);
        ResponseEntity<?> response = afinidadeService.cadastroAfinidade(afinidadeDto);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }


}
