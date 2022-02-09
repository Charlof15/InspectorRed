package com.ffm.inspector.red.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.model.input.Archivo;
import com.ffm.inspector.red.model.input.DetalleIncidencia;

import com.ffm.inspector.red.model.input.RegistroIncidencia;
import com.ffm.inspector.red.model.output.ConsultaGeografia;
import com.ffm.inspector.red.model.output.ConsultaUrlImagen;

@Service
public class InspectorIncidenciaService extends InspectorIncidencia {

	public static final String URL_CLUSTER = "CLUSTER_TOTALPLAY";

	@SuppressWarnings("unchecked")
	public Object registroIncidencia(RegistroIncidencia inputRegistro) {

		Map<String, Configuracion> config = configuraciones();
		String url = config.get(URL_CLUSTER).getValor();
		System.out.println("Valor de latitud : " + inputRegistro.getLatitud());
		url = url.replaceAll("VALOR_LAT", inputRegistro.getLatitud());
		url = url.replaceAll("VALOR_LONG", inputRegistro.getLongitud());

		ResponseEntity<ConsultaGeografia> resultWsFactibilidad = (ResponseEntity<ConsultaGeografia>) requestApi(url,
				null, HttpMethod.GET, ConsultaGeografia.class);

		if (resultWsFactibilidad.getStatusCode().is2xxSuccessful()) {
			System.out.println("AQUI 1");
			System.err.println(resultWsFactibilidad.getBody().getClusterTotalplay());
			System.err.println(gson.toJson(resultWsFactibilidad.getBody()));
			System.out.println("GEOGRAFIA " + resultWsFactibilidad.getBody().toString());
			int idGeo = inspectorMapper.consultaGeografia(resultWsFactibilidad.getBody().toString());
			inputRegistro.setIdGeografia(idGeo);
			inputRegistro.setIdPropietario(1);
			inputRegistro.setIdUnidadNegocio(1);
			inputRegistro.setIdUsuario(22);

//			inputRegistro.setIdPropietario(var.getDetalleJWT().getIdPropietario());
//			inputRegistro.setIdUnidadNegocio(var.getDetalleJWT().getIdUnidadNegocio());

		} else {
//			if (resultWsFactibilidad.getBody().toString() == null) {
//				this.inspectorMapper.registroIncidencia(inputRegistro);
//				System.err.println("Se realizo registro con cluster NULL");
//			}
		}
		/** :::::::::::::FOR PARA INSERTAR EN TABLA PRINCIPAL:::::::::: **/
		for (DetalleIncidencia incidencia : inputRegistro.getIncidenciasReportadas()) {
			inputRegistro.setIdTipoIncidencia(incidencia.getIdTipoIncidencia());
			inputRegistro.setIdSubTipoIncidencia(incidencia.getIdSubTipoIncidencia());
			inspectorMapper.registroIncidencia(inputRegistro);
			break;
		}
		System.out.println("ID REGISTRO " + inputRegistro.getIdRegistroIncidencia());

		/** ::::::::::::::::FOR PARA INSERTAR EN DETALLE:::::::::::::///// **/
		for (DetalleIncidencia incidencia : inputRegistro.getIncidenciasReportadas()) {
			inputRegistro.setIdTipoIncidencia(incidencia.getIdTipoIncidencia());
			inputRegistro.setIdSubTipoIncidencia(incidencia.getIdSubTipoIncidencia());
			incidencia.setIdRegistroIncidencia(inputRegistro.getIdRegistroIncidencia());
			inspectorMapper.registroDetalleIncidente(incidencia);
			// ::::::::::::::::FOR PARA INSERTAR EN EVIDENCIAS::::::::::::://////

			for (Archivo evidencias : incidencia.getEvidencias().getArchivos()) {
				// llama el ws de subida de archivos

				ResponseEntity<ConsultaUrlImagen> resultWsUtileriasGoogle = (ResponseEntity<ConsultaGeografia>) requestApi(
						url, null, HttpMethod.GET, ConsultaGeografia.class);
			}
		}
		System.err.println(gson.toJson(resultWsFactibilidad));

		return null;

	}
}
