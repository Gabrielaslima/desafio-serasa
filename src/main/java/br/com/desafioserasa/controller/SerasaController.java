package br.com.desafioserasa.controller;

import br.com.desafioserasa.model.dto.AfinidadeDTO;
import br.com.desafioserasa.model.dto.PessoaDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeDTO;
import br.com.desafioserasa.model.dto.ScoreDTO;
import br.com.desafioserasa.serviceImpl.AfinidadeService;
import br.com.desafioserasa.serviceImpl.PessoaService;
import br.com.desafioserasa.serviceImpl.ScoreService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/serasa")
@Api("API referente ao cadastro de Score de pessoas")
public class SerasaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private AfinidadeService afinidadeService;

    @PostMapping(value = "/pessoa")
    public ResponseEntity<String> postPessoa(@RequestBody PessoaDTO body) {
        ResponseEntity<String> response = pessoaService.cadastroPessoa(body);
        return response;
    }

    @PostMapping(value = "/afinidade")
    public ResponseEntity<String> postAfinidade(@RequestBody AfinidadeDTO body) {
        ResponseEntity<String> response = afinidadeService.cadastroAfinidade(body);
        return response;
    }

    @PostMapping(value = "/score")
    public ResponseEntity<String> postScore(@RequestBody ScoreDTO body) {
        ResponseEntity<String> response = scoreService.cadastroScore(body);
        return response;
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<?> getPessoaId(@PathVariable Long id) {
        ResponseEntity<?> response = pessoaService.getById(id);
        return response;
    }

    @GetMapping(value = "/pessoa")
    public ResponseEntity<?> getPessoa() {
        ResponseEntity<?> response = pessoaService.listAll();
        return response;
    }
}
