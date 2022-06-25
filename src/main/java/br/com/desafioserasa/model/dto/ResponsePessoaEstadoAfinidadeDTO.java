package br.com.desafioserasa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePessoaEstadoAfinidadeDTO implements Serializable {

    private String nome;

    private String scoreDescricao;

    private List<String> estados;

}
