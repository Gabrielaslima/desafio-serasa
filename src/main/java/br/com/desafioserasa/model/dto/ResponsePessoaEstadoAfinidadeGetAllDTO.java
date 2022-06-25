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
public class ResponsePessoaEstadoAfinidadeGetAllDTO extends ResponsePessoaEstadoAfinidadeDTO implements Serializable {

    private String estado;

    private String cidade;

}
