package br.com.desafioserasa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstadoAfinidadeId implements Serializable {

    @Column(name = "afinidade_id")
    private Long afinidadeId;

    @Column(name = "estado_id")
    private Long estadoId;

}
