package com.ffm.inspector.red.model.input.registroIncidencia;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroIncidencia {
	private String latitud;
    private String longitud;
    private List<DetalleIncidencia> incidenciasReportadas;
    @JsonIgnore private Integer idRegistroIncidencia;
	@JsonIgnore private Integer idGeografia;
	@JsonIgnore private Integer idUnidadNegocio;
	@JsonIgnore private Integer idPropietario;
	@JsonIgnore private Integer idUsuario;
	@JsonIgnore private Integer idTipoIncidencia;
	@JsonIgnore private Integer idSubTipoIncidencia;
	
}
