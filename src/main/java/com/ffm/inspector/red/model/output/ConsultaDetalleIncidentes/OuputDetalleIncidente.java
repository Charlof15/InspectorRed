package com.ffm.inspector.red.model.output.ConsultaDetalleIncidentes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuputDetalleIncidente {
	  	private String idIncidente;
	    private int idDetalleIncidente;
	    private String idFalla;
	    private String descTipoFalla;
	    private String idSubtipoFalla;
	    private String descSubtipoFalla;
	    private String comentarios;
	    private OuputDetalleEvidencia evidencias;
}
