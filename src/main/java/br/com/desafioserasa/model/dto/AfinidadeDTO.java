package br.com.desafioserasa.model.dto;

import br.com.desafioserasa.entity.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AfinidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String regiao;

    private List<EstadoDTO> estadosList;

    public List<EstadoDTO> getEstadosList() {
        return estadosList == null ? new ArrayList<>() : estadosList;
    }

}
