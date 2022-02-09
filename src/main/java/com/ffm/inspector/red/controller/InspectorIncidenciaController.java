package com.ffm.inspector.red.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffm.inspector.red.model.input.RegistroIncidencia;
import com.ffm.inspector.red.service.InspectorIncidenciaService;

@RestController
public class InspectorIncidenciaController {

	@Autowired
	private InspectorIncidenciaService service;

	@PostMapping(path = "/RegistroIncidencias")
	public Object registroIncidente(@RequestBody RegistroIncidencia inputRegistro) {
		System.out.println("AQui");
		return service.registroIncidencia(inputRegistro);
//		return inputRegistro;
	}

}
