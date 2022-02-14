package com.ffm.inspector.red.model.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputIncidentesSinGeografia {
	private String idIncidencia;
	private String idUsuarioReporta;
	private String numeroEmpleado;
	private String usuarioReporta;
	private String idTipoIncidencia;
	private String idSubTipoIncidencia;
	private String fechaRegistro;
	private String horaRegistro;
	private String latitud;
	private String longitud;
	private String idEstatus;
	private String descEstatus;
	private String colorEstatus;
	private int idUnidadNegocio;
	private int idPropietario;

}
