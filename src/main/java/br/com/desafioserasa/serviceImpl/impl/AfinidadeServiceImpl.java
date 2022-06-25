package br.com.desafioserasa.serviceImpl.impl;

import br.com.desafioserasa.entity.Afinidade;
import br.com.desafioserasa.model.dto.AfinidadeDTO;
import br.com.desafioserasa.repository.IAfinidadeRepository;
import br.com.desafioserasa.serviceImpl.AfinidadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AfinidadeServiceImpl implements AfinidadeService {

    @Autowired
    public IAfinidadeRepository afinidadeRepository;

    @Override
    public ResponseEntity<String> cadastroAfinidade(AfinidadeDTO afinidadeDTO) {

        try {
            Afinidade afinidade = new Afinidade(afinidadeDTO);
            afinidadeRepository.save(afinidade);

            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar afinidade.");
        }

    }
}
