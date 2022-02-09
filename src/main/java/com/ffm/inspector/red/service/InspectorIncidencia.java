package com.ffm.inspector.red.service;

import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.component.Variables;
import com.ffm.inspector.red.mapper.InspectorIncidenciaMapper;
import com.ffm.inspector.red.model.output.ConsultaGeografia;
import com.google.gson.Gson;


public class InspectorIncidencia{
	
	Gson gson = new Gson();
	ConsultaGeografia geo = new ConsultaGeografia();

	@Autowired
	Variables var;
	
	@Autowired
	InspectorIncidenciaMapper inspectorMapper;
	
	public  Map<String, Configuracion> configuraciones(){
		Map<String, Configuracion> configuraciones = inspectorMapper.consultaConfiguracion(
			var.getDetalleJWT().getIdPropietario(), var.getDetalleJWT().getIdUnidadNegocio());
		return configuraciones;
	}

	public ResponseEntity<?> requestApi(String url,String body, HttpMethod metodo,Class<?> clase){
		try {
			HttpHeaders headers = new HttpHeaders();
			RestTemplate restTemplate = new RestTemplate();
			HttpClient httpClient = HttpClientBuilder.create().build();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));    
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(var.getSessionId());
			HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
			return restTemplate.exchange(url, metodo, requestEntity,clase);
		} catch (Exception e) {
			System.err.println(e.toString());
			return new ResponseEntity<Object>("Error : " + e.toString(),HttpStatus.FAILED_DEPENDENCY);
		}
	
	}
}