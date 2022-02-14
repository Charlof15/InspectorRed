package com.ffm.inspector.red.model.output;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Incidencias extends OutputGeneral {
	
    private List<OutputDetalleIncidencias> detalleIncidencias;

}
