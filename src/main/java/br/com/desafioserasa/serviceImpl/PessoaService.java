package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.model.dto.PessoaDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeDTO;
import org.springframework.http.ResponseEntity;

public interface PessoaService {

    ResponseEntity<String> cadastroPessoa(PessoaDTO pessoaDto);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> listAll();

}
