package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.entity.Pessoa;
import br.com.desafioserasa.model.dto.PessoaDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeGetAllDTO;
import br.com.desafioserasa.repository.IPessoaRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaServiceImpl {

    @Autowired
    private PessoaService pessoaService;

    @Mock
    private IPessoaRepository pessoaRepository;

    @Test
    public void testCadastroPessoa() {

        PessoaDTO pessoaDTO = new PessoaDTO();
        Pessoa pessoa = new Pessoa();

        Mockito.when(pessoaRepository.save(Mockito.any())).thenReturn(pessoa);
        ResponseEntity<?> response = pessoaService.cadastroPessoa(pessoaDTO);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }

    @Test
    public void testGetById() {

        Optional<Pessoa> pessoa = Optional.empty();
        PessoaDTO pessoaDTO = new PessoaDTO();

        Mockito.when(pessoaRepository.save(Mockito.any())).thenReturn(pessoa);
        ResponseEntity<?> response = pessoaService.getById(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void testListAll() {

        List<ResponsePessoaEstadoAfinidadeGetAllDTO> pessoas = new ArrayList<ResponsePessoaEstadoAfinidadeGetAllDTO>();
        Mockito.when(pessoaRepository.save(Mockito.any())).thenReturn(pessoas);

        ResponseEntity<?> response = pessoaService.listAll();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
