package br.com.desafioserasa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePessoaEstadoAfinidadeGetByIdDTO extends ResponsePessoaEstadoAfinidadeDTO implements Serializable {

    private Long idade;

    private String telefone;

}
