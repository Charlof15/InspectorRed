package com.ffm.inspector.red.model.input.registroIncidencia;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evidencia {
	List<Archivo> archivos;
	

}
