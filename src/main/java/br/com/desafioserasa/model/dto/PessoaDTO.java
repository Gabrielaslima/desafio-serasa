package br.com.desafioserasa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    private String telefone;

    private long idade;

    private String cidade;

    private String estado;

    private long score;

    private String regiao;

}
