package com.ffm.inspector.red.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffm.inspector.red.model.input.consultaIncidencia.ConsultaIncidente;
import com.ffm.inspector.red.model.input.registroIncidencia.RegistroIncidencia;
import com.ffm.inspector.red.model.output.OutputGeneral;
import com.ffm.inspector.red.service.InspectorIncidenciaService;



@RestController
public class InspectorIncidenciaController  {
	//implements IdocumentacionInspectorRedIncidencia

	@Autowired
	private InspectorIncidenciaService serviceInspector;
	
	
	@PostMapping(path = "/RegistroIncidencias")
	public Object registroIncidente(@RequestBody RegistroIncidencia inputRegistro) {
//		return new ResponseEntity<>(serviceInspector.registroIncidencia(inputRegistro),HttpStatus.OK);	
	return serviceInspector.registroIncidencia(inputRegistro);
	}

	@GetMapping(path = "/localizadas")
	public Object consultaIncidente(@RequestBody ConsultaIncidente inputConsulta) {
		return serviceInspector.consultaIncidente(inputConsulta);	}
	
		@GetMapping(path = "/ilocalizables?idsFallas={idTipoIncidencia}&fechaInicio={fechaInicio}&fechaFin={fechaFin}")
		public Object consultaIncidentesSinGeografia(@PathVariable(value = "idTipoIncidencia") List<Integer> idTipoIncidencia,@PathVariable(value = "fechaInicio") String fechaInicio,
				@PathVariable(value = "fechaFin") String fechaFin) {
			return serviceInspector.consultaIncidentesSinGeografia(idTipoIncidencia, fechaInicio, fechaFin);
			
		
	}
	
		

}
