package com.ffm.inspector.red.service;

import java.util.List;
import java.util.Map;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.model.input.consultaIncidencia.ConsultaIncidente;
import com.ffm.inspector.red.model.input.registroIncidencia.Archivo;
import com.ffm.inspector.red.model.input.registroIncidencia.DetalleIncidencia;
import com.ffm.inspector.red.model.input.registroIncidencia.RegistroIncidencia;
import com.ffm.inspector.red.model.output.ConsultaGeografia;
import com.ffm.inspector.red.model.output.Incidencias;
import com.ffm.inspector.red.model.output.OutputDetalleIncidencias;
import com.ffm.inspector.red.model.output.OutputGeneral;
import com.ffm.inspector.red.model.output.OutputIncidentesSinGeografia;

@Service
public class InspectorIncidenciaService extends InspectorIncidencia {

	private static final String URL_CLUSTER = "CLUSTER_TOTALPLAY";
	private static final String URL_IMAGEN = "WS_UTILERIAS_GOOGLE";
	private static final String BUCKET_ID = "BUCKET_ID";
	private static final String PATH_EVIDENCIAS = "PATH_EVIDENCIAS";

	@SuppressWarnings("unchecked")
	public OutputGeneral registroIncidencia(RegistroIncidencia inputRegistro) {
		Map<String, Configuracion> config = configuraciones();
		String url = config.get(URL_CLUSTER).getValor();
		System.out.println("Valor de latitud : " + inputRegistro.getLatitud());
		url = url.replaceAll("VALOR_LAT", inputRegistro.getLatitud());
		url = url.replaceAll("VALOR_LONG", inputRegistro.getLongitud());

		ResponseEntity<ConsultaGeografia> resultWsFactibilidad = (ResponseEntity<ConsultaGeografia>) requestApi(url,
				null, HttpMethod.GET, ConsultaGeografia.class);
		inputRegistro.setIdPropietario(var.getDetalleJWT().getIdPropietario());
		inputRegistro.setIdUnidadNegocio(var.getDetalleJWT().getIdUnidadNegocio());
		inputRegistro.setIdUsuario(22);

		if (resultWsFactibilidad.getBody().toString().equals("")) {
			System.out.println("AQUI IF");
			inputRegistro.setIdGeografia(null);

		} else {
			System.out.println("AQUI ELSE");
			int idGeo = inspectorMapper.consultaGeografia(resultWsFactibilidad.getBody().toString());
			inputRegistro.setIdGeografia(idGeo);
		}

		/** :::::::::::::FOR PARA INSERTAR EN TABLA PRINCIPAL:::::::::: **/
		for (DetalleIncidencia incidencia : inputRegistro.getIncidenciasReportadas()) {
			inputRegistro.setIdTipoIncidencia(incidencia.getIdTipoIncidencia());
			inputRegistro.setIdSubTipoIncidencia(incidencia.getIdSubTipoIncidencia());
			inspectorMapper.registroIncidencia(inputRegistro);
			break;
		}

		/** ::::::::::::::::FOR PARA INSERTAR EN DETALLE:::::::::::::///// **/
		for (DetalleIncidencia incidencia : inputRegistro.getIncidenciasReportadas()) {
			inputRegistro.setIdTipoIncidencia(incidencia.getIdTipoIncidencia());
			inputRegistro.setIdSubTipoIncidencia(incidencia.getIdSubTipoIncidencia());
			incidencia.setIdRegistroIncidencia(inputRegistro.getIdRegistroIncidencia());
			incidencia.setIdPropietario(var.getDetalleJWT().getIdPropietario());
			incidencia.setIdUnidadNegocio(var.getDetalleJWT().getIdUnidadNegocio());
			inspectorMapper.registroDetalleIncidente(incidencia);

			// ** ::::::::::::::::FOR PARA INSERTAR EN EVIDENCIAS:::::::::::::**//////

			for (Archivo evidencias : incidencia.getEvidencias().getArchivos()) {

				String urlImagen = config.get(URL_IMAGEN).getValor();
				evidencias.setBucketId(config.get(BUCKET_ID).getValor());
				ResponseEntity<String> resultWsUtileriasGoogle = (ResponseEntity<String>) requestApi(urlImagen,
						gson.toJson(evidencias), HttpMethod.POST, String.class);

				String pathFile = config.get(BUCKET_ID).getValor().concat(config.get(PATH_EVIDENCIAS).getValor())
						.concat(getYearFormat.format(date)).concat("/" + incidencia.getIdRegistroDetalle());

				evidencias.setIdRegistroIncidencia(incidencia.getIdRegistroDetalle());
				evidencias.setStoragePath(pathFile);
				evidencias.setUrlFoto(resultWsUtileriasGoogle.getBody().toString());
				evidencias.setLatitud(inputRegistro.getLatitud());
				evidencias.setLongitud(inputRegistro.getLongitud());
				inspectorMapper.registroEvidencia(evidencias);

			}
			outputGeneral.setInstancia(var.getInstancia());
		}

		return outputGeneral;

	}

	public Incidencias consultaIncidente(ConsultaIncidente inputConsulta) {
				Incidencias outputIncidencias = new Incidencias();
		List<OutputDetalleIncidencias> incidencias = inspectorMapper.consultaIncidente(inputConsulta);
		outputIncidencias.setDetalleIncidencias(incidencias);
		outputIncidencias.setInstancia(var.getInstancia());
		return outputIncidencias;
	}

	public Object consultaIncidentesSinGeografia(List<Integer> idTipoIncidencia, String fechaInicio,String fechaFin) {
		List<OutputIncidentesSinGeografia> ouputSinGeografia = inspectorMapper.consultaIncidentesSinGeografia(idTipoIncidencia, fechaInicio, fechaFin);
		return ouputSinGeografia;
		
	}
}
