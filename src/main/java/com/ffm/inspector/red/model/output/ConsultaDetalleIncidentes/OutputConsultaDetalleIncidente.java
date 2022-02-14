package com.ffm.inspector.red.model.output.ConsultaDetalleIncidentes;

import java.util.List;

import com.ffm.inspector.red.model.output.OutputGeneral;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputConsultaDetalleIncidente extends OutputGeneral {
	private List<OuputDetalleIncidente> detalleIncidentes;
}
