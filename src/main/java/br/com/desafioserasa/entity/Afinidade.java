package br.com.desafioserasa.entity;

import br.com.desafioserasa.model.dto.AfinidadeDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AFINIDADE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Afinidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regiao;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "estado_afinidade",
            joinColumns={@JoinColumn(name="afinidade_id",
            referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="estado_id",
                    referencedColumnName="id")})
    private List<Estado> estadosList;

    public Afinidade(AfinidadeDTO afinidadeDTO) {
        this.estadosList = new ArrayList<Estado>();
        this.regiao = afinidadeDTO.getRegiao();
        afinidadeDTO.getEstadosList().forEach(estado -> {
            Estado newEstado = new Estado(estado);
            this.estadosList.add(newEstado);
        });
    }

    public List<Estado> getEstadosList() {
        return estadosList == null ? new ArrayList<>() : estadosList;
    }
}
