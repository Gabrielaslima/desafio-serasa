package br.com.desafioserasa.entity;

import br.com.desafioserasa.model.dto.EstadoDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ESTADO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Estado (EstadoDTO estadoDTO) {
        this.nome = estadoDTO.getNome();
    }

}
