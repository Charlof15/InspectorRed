package com.ffm.inspector.red.model.input.registroIncidencia;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archivo {
	private String nombre;
    private String archivo;
    private String extension;
    @JsonIgnore private String bucketId;
    @JsonIgnore private String storagePath;
    @JsonIgnore private String urlFoto;
    @JsonIgnore private Integer idRegistroIncidencia;
    @JsonIgnore private String latitud;
    @JsonIgnore private String longitud;
    

}
