package br.com.desafioserasa.entity;

import br.com.desafioserasa.model.dto.PessoaDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "PESSOA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "data_inclusao",
        nullable = true, updatable = false)
    private Date dataInclusao;

    private String nome;

    private String telefone;

    private long idade;

    private String cidade;

    private String estado;

    private long score;

    private String regiao;

    public Pessoa(PessoaDTO pessoaDto) {
        this.nome = pessoaDto.getNome();
        this.telefone = pessoaDto.getTelefone();
        this.idade = pessoaDto.getIdade();
        this.cidade = pessoaDto.getCidade();
        this.estado = pessoaDto.getEstado();
        this.score = pessoaDto.getScore();
        this.regiao = pessoaDto.getRegiao();
    }

}
