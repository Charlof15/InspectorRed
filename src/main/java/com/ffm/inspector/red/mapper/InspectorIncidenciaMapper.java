package com.ffm.inspector.red.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.model.input.consultaIncidencia.ConsultaIncidente;
import com.ffm.inspector.red.model.input.registroIncidencia.Archivo;
import com.ffm.inspector.red.model.input.registroIncidencia.DetalleIncidencia;
import com.ffm.inspector.red.model.input.registroIncidencia.RegistroIncidencia;
import com.ffm.inspector.red.model.output.Incidencias;
import com.ffm.inspector.red.model.output.OutputDetalleIncidencias;
import com.ffm.inspector.red.model.output.OutputIncidentesSinGeografia;

import feign.Param;



@Mapper
public interface InspectorIncidenciaMapper {
	
	@MapKey("llave")
	Map<String,Configuracion> consultaConfiguracion(@Param(value = "idPropietario") Integer idPropietario,@Param(value = "idUnidadNegocio") Integer idUnidadNegocio);
	
	int consultaGeografia(String clusterTotalplay);

	int registroIncidencia(RegistroIncidencia inputRegistro);
	
	int registroDetalleIncidente(DetalleIncidencia inputDetalle);

	int registroEvidencia(Archivo archivo);
	
	List<OutputDetalleIncidencias> consultaIncidente(@Param("incidenteConsulta") ConsultaIncidente incidenteConsulta);
	
	List<OutputIncidentesSinGeografia> consultaIncidentesSinGeografia(List<Integer> idTipoIncidencia, String fechaInicio,String fechaFin);
}