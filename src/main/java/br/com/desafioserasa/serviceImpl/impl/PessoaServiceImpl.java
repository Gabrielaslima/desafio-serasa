package br.com.desafioserasa.serviceImpl.impl;

import br.com.desafioserasa.entity.Pessoa;
import br.com.desafioserasa.model.dto.PessoaDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeGetAllDTO;
import br.com.desafioserasa.model.dto.ResponsePessoaEstadoAfinidadeGetByIdDTO;
import br.com.desafioserasa.repository.IAfinidadeRepository;
import br.com.desafioserasa.repository.IPessoaRepository;
import br.com.desafioserasa.repository.IScoreRepository;
import br.com.desafioserasa.serviceImpl.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private IPessoaRepository pessoaRepository;

    @Autowired
    private IAfinidadeRepository afinidadeRepository;

    @Autowired
    private IScoreRepository scoreRepository;

    @Override
    public ResponseEntity<String> cadastroPessoa(PessoaDTO pessoaDto) {

        try {
            Pessoa newPessoa = new Pessoa(pessoaDto);
            pessoaRepository.save(newPessoa);

            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar pessoa.");
        }

    }

    @Override
    public ResponseEntity<?> getById(Long id) {

        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);

            if (pessoa.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {

                List<String> listaEstadosPessoa = afinidadeRepository.findAllEstadosPorAfinidadePessoa(pessoa.get().getRegiao());

                String scoreDescricao = scoreRepository.findScoreDescricao(pessoa.get().getScore());

                ResponsePessoaEstadoAfinidadeGetByIdDTO dto = new ResponsePessoaEstadoAfinidadeGetByIdDTO();

                dto.setNome(pessoa.get().getNome());
                dto.setIdade(pessoa.get().getIdade());
                dto.setTelefone(pessoa.get().getTelefone());
                dto.setScoreDescricao(scoreDescricao);
                dto.setEstados(listaEstadosPessoa);

                return ResponseEntity.status(HttpStatus.OK).body(dto);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar pessoa.");
        }

    }

    @Override
    public ResponseEntity<?> listAll() {

        try {
            List<Pessoa> listaPessoas = pessoaRepository.findAll();

            List<ResponsePessoaEstadoAfinidadeGetAllDTO> responseDto = new ArrayList<ResponsePessoaEstadoAfinidadeGetAllDTO>();

            listaPessoas.forEach(pessoa -> {
                List<String> listaEstadosPessoa = afinidadeRepository.findAllEstadosPorAfinidadePessoa(pessoa.getRegiao());

                String scoreDescricao = scoreRepository.findScoreDescricao(pessoa.getScore());

                ResponsePessoaEstadoAfinidadeGetAllDTO dto = new ResponsePessoaEstadoAfinidadeGetAllDTO();

                dto.setCidade(pessoa.getCidade());
                dto.setEstado(pessoa.getEstado());
                dto.setNome(pessoa.getNome());
                dto.setScoreDescricao(scoreDescricao);
                dto.setEstados(listaEstadosPessoa);

                responseDto.add(dto);
            });

            if (responseDto.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar lista de pessoas.");
        }

    }
}
