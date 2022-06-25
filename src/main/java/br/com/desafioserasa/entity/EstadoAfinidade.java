package br.com.desafioserasa.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "ESTADO_AFINIDADE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstadoAfinidade implements Serializable {

    @EmbeddedId
    private EstadoAfinidadeId estadoAfinidadeId;

}
