package com.ffm.inspector.red.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.model.input.registroIncidencia.Archivo;
import com.ffm.inspector.red.model.input.registroIncidencia.RegistroIncidencia;
import com.ffm.inspector.red.model.output.ConsultaGeografia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtileriasInspector {

//	private static final String URL_CLUSTER = "CLUSTER_TOTALPLAY";
//	private static final String URL_IMAGEN = "WS_UTILERIAS_GOOGLE";
//	private static final String BUCKET_ID = "BUCKET_ID";
//	private static final String PATH_EVIDENCIAS = "PATH_EVIDENCIAS";
//	
//	Map<String, Configuracion> config = configuraciones();
//	public RegistroIncidencia inputRegistroIncidencia(RegistroIncidencia inputRegistro) {
//		
//		String url = config.get(URL_CLUSTER).getValor();
//		url = url.replaceAll("VALOR_LAT", inputRegistro.getLatitud());
//		url = url.replaceAll("VALOR_LONG", inputRegistro.getLongitud());
//
//		ResponseEntity<ConsultaGeografia> resultWsFactibilidad = (ResponseEntity<ConsultaGeografia>) requestApi(url,
//				null, HttpMethod.GET, ConsultaGeografia.class);
//
//		if (resultWsFactibilidad.getStatusCode().is2xxSuccessful()) {
//			int idGeo = inspectorMapper.consultaGeografia(resultWsFactibilidad.getBody().toString());
//			inputRegistro.setIdGeografia(idGeo);
//			inputRegistro.setIdPropietario(var.getDetalleJWT().getIdPropietario());
//			inputRegistro.setIdUnidadNegocio(var.getDetalleJWT().getIdUnidadNegocio());
//			inputRegistro.setIdUsuario(22);
//
//		} else {
////			if (resultWsFactibilidad.getBody().toString() == null) {
////				this.inspectorMapper.registroIncidencia(inputRegistro);
////				System.err.println("Se realizo registro con cluster NULL");
////			}
//		}
//		return inputRegistro;
//	}
//	public void inputEvidencias(Archivo evidencias) {
//		String urlImagen = config.get(URL_IMAGEN).getValor();
//		evidencias.setBucketId(config.get(BUCKET_ID).getValor());
//		ResponseEntity<String> resultWsUtileriasGoogle = (ResponseEntity<String>) requestApi(urlImagen,
//				gson.toJson(evidencias), HttpMethod.POST, String.class);
//
//		String pathFile = config.get(BUCKET_ID).getValor().concat(config.get(PATH_EVIDENCIAS).getValor())
//				.concat(getYearFormat.format(date)).concat("/" + incidencia.getIdRegistroDetalle());
//	}
}
