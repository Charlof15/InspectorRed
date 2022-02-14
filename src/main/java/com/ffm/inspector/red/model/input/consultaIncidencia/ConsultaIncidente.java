package com.ffm.inspector.red.model.input.consultaIncidencia;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaIncidente {

	private List<Integer> idEstatus;
    private List<Integer> idSubTipoFallas;
    private String fechaInicio;
    private String fechaFin;
    private List<Integer> idGeografias;
}
