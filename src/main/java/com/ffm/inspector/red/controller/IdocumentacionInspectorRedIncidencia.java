package com.ffm.inspector.red.controller;

import org.springframework.http.ResponseEntity;

import com.ffm.inspector.red.model.input.registroIncidencia.RegistroIncidencia;
import com.ffm.inspector.red.model.output.OutputGeneral;
import com.ffm.inspector.red.utility.OpenApiConfig;
import com.totalplay.utils.arquetipo.output.Output;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@OpenApiConfig
public interface IdocumentacionInspectorRedIncidencia {
	@Operation(summary = "Registra de inicidente", description = "Registra en inspector incidencia", security = @SecurityRequirement(name = "Authorization"))
	@ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content(
			schema = @Schema(implementation = Output.class), mediaType = "application/json",
			examples = { @ExampleObject(value = "{\n" +
					"   \"mensaje\":\"Consulta de asistencia.\",\n" +
					"   \"description\":\"Ejecución correcta\",\n" +
					"   \"version\":1.0,\n" +
					"   \"instancia\":\"Google\"\n" +
					"}")}))
	ResponseEntity<OutputGeneral> registroIncidente(
			@Schema(example = "{\n" +
					"\t\"latitud\": 19.333245986851846,\n" +
					"\t\"longitud\": -99.20009107780517,\n" +
					"\t\"incidenciasReportadas\": [{\n" +
					"\t\t\"idTipoIncidencia\": \"2\",\n" +
					"\t\t\"idSubTipoIncidencia\": \"2\",\n" +
					"\t\t\"comentarios\": \"\",\n" +
					"\t\t\"evidencias\": {\n" +
					"\t\t\t\"archivos\": [{\n" +
					"\t\t\t\t\"nombre\": \"archivos/ejemplo.txt\",\n" +
					"\t\t\t\t\"extension\": \"jpg\",\n" +
					"\t\t\t\t\"archivo\": \"UHJ1ZWJhIHBhcmEgZGV0YWxsZSBub3RpY2lhcw==\"\n" +
					"\t\t\t}]\n" +
					"\t\t}\n" +
					"\t}]\n" +
					"}")
			RegistroIncidencia request
	);
}	
	
	
	
