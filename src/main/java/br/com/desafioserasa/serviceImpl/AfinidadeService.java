package br.com.desafioserasa.serviceImpl;

import br.com.desafioserasa.model.dto.AfinidadeDTO;
import org.springframework.http.ResponseEntity;

public interface AfinidadeService {

    ResponseEntity<String> cadastroAfinidade(AfinidadeDTO afinidadeDTO);

}
