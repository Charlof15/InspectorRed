package com.ffm.inspector.red.model.input;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetalleIncidencia {
	private Integer idTipoIncidencia;
    private Integer idSubTipoIncidencia;
    private String comentarios;
    private Evidencia evidencias;
    @JsonIgnore private Integer idRegistroIncidencia;
    @JsonIgnore private Integer idUnidadNegocio;
	@JsonIgnore private Integer idPropietario;
	@JsonIgnore private Integer idRegistroDetalle;
   
	
    
    

}
